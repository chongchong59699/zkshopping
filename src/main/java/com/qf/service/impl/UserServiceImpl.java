package com.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.qf.config.RedisKeyConfig;
import com.qf.dao.UserDao;
import com.qf.dto.FindPassUserDto;
import com.qf.dto.LoginUserDto;
import com.qf.dto.RegisterUserDto;
import com.qf.dto.UpdateUserDto;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.util.*;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import static com.qf.util.MailUtils.getValidateCode;


/**
 * @author: Sophia
 * @date: 2020/7/18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JedisCore jedisCore;

    //private JedisCore jedisCore=JedisUtil.getJedisCore();

    /**
     * 秘钥
     */
    @Value("${zkwg.aes.passkey}")
    private String key;

    /**
     * 校验手机号
     *
     * @param phone 手机号
     * @return
     */
    @Override
    public R checkPhone(String phone) {
        User user = userDao.selectUserByPhone(phone);
        if (user != null) {
            return R.error("该手机号已注册！");
        } else {
            return R.ok();
        }

    }


    /**
     * 校验邮箱
     *
     * @param email 邮箱
     * @return
     */
    @Override
    public R checkEmail(String email) {
        User user = userDao.selectUserByEmail(email);
        if (user != null) {
            return R.error("该邮箱已注册！");
        } else {
            return R.ok();
        }

    }

    /**
     * 添加用户
     *
     * @param registerUserDto 用户注册信息
     * @return
     */
    @Transactional
    @Override
    public R addUser(RegisterUserDto registerUserDto) {

        // 检查该用户是否已经注册
        if (checkEmail(registerUserDto.getEmail()).getCode() == 200
                && checkPhone(registerUserDto.getPhone()).getCode() == 200) {

            // 判断验证码是否发送成功
            if (jedisCore.checkKey(RedisKeyConfig.CODE_REGISTER + registerUserDto.getEmail())) {

                String code = jedisCore.get(RedisKeyConfig.CODE_REGISTER + registerUserDto.getEmail());

                // 验证用户输入的验证码与发送的验证码是否一致
                if (code.equals(registerUserDto.getCode())) {
                    User user = new User();

                    user.setUsername(registerUserDto.getUsername());
                    user.setNickname(registerUserDto.getNickname());
                    // 将密码转换成密文
                    user.setPassword(EncryptUtil.aesenc(key, registerUserDto.getPassword()));
                    user.setPhone(registerUserDto.getPhone());
                    user.setEmail(registerUserDto.getEmail());

                    // 添加用户
                    userDao.insertUser(user);

                    return R.ok();
                } else {
                    return R.error("验证码错误，请重新操作");
                }

            } else {
                return R.error("请先发送验证码");
            }

        } else {

            return R.error("该邮箱或手机号已经注册");
        }

    }

    /**
     * 用户登录
     *
     * @param loginUserDto 用户登录信息
     * @return
     */
    @Override
    public R userLogin(LoginUserDto loginUserDto) {

        // 校验该用户是否被冻结
        if (jedisCore.checkKey(RedisKeyConfig.EMAIL_FOR + loginUserDto.getEmail())) {

            return R.error("您的账号已被冻结，请" + jedisCore.ttl(RedisKeyConfig.EMAIL_FOR +
                    loginUserDto.getEmail()) + "秒之后登录");

        } else if (jedisCore.checkKey(RedisKeyConfig.EMAIL_TOKEN + loginUserDto.getEmail())) {

            return R.error("您的账号已经登录啦");
        } else {
            User user = userDao.selectUser(loginUserDto.getEmail());
            // 登录标记
            boolean isError = true;

            if (user != null) {

                // 校验用户密码是否相等
                if (user.getPassword().equals(EncryptUtil.aesenc(key, loginUserDto.getPassword()))) {
                    // 成功登录  生成令牌 设置有效期 存储到Redis
                    String token = TokenUtil.createToken(user.getId());

                    // 存储用户账号信息
                    jedisCore.set(RedisKeyConfig.EMAIL_TOKEN + loginUserDto.getEmail(), token, RedisKeyConfig.TOKEN_TIME);
                    // 存储user信息
                    jedisCore.set(RedisKeyConfig.TOKEN_USER + token, JSON.toJSONString(user), RedisKeyConfig.TOKEN_TIME);

                    // 登录成功
                    isError = false;
                    // 返回token
                    return R.ok(token);
                }

            }
            // 登录失败
            if (isError) {

                // 判断10分钟内错误次数
                if (jedisCore.keys(RedisKeyConfig.EMAIL_ERROR + loginUserDto.getEmail() + "*") == 2) {
                    // 冻结账号，设置冻结时间，默认30分钟
                    jedisCore.set(RedisKeyConfig.EMAIL_FOR + loginUserDto.getEmail(), System.currentTimeMillis() + "", RedisKeyConfig.TOKENFOR_TIME);
                }

                // 记录本次错误，10分钟内错误3次，冻结账号10分钟
                jedisCore.set(RedisKeyConfig.EMAIL_TOKEN + loginUserDto.getEmail() + ":" + System.currentTimeMillis(), "", RedisKeyConfig.PHONERROR_TIME);
            }
        }

        return R.error("账号或者密码错误");

    }

    /**
     * 忘记密码，用来找回密码
     *
     * @param findPassUserDto 用户登录信息
     * @return
     */
    @Override
    public R findPassword(FindPassUserDto findPassUserDto) {
        // 判断修改密码时是否发送了验证码
        if (jedisCore.checkKey(RedisKeyConfig.CODE_FINDPASS + findPassUserDto.getEmail())) {

            String code = jedisCore.get(RedisKeyConfig.CODE_FINDPASS + findPassUserDto.getEmail());

            // 判断验证码是否与发送的邮箱验证码一致
            if (code.equals(findPassUserDto.getCode())) {

                // 修改密码
                if (userDao.updatePassword(findPassUserDto.getEmail(), EncryptUtil.aesenc(key, findPassUserDto.getPassword())) > 0) {
                    return R.ok("密码修改成功！");
                } else {
                    return R.error("该账号不存在！");
                }

            } else {
                return R.error("验证码错误，请重新操作");
            }
        } else {
            return R.error("请先获取验证码");
        }

    }


    /**
     * 查看用户信息
     *
     * @param token
     * @return
     */
    @Override
    public R selectUserById(String token) {
        User user = TokenUtil.getUserFromToken(token, jedisCore);
        if (user != null) {
            return R.ok(userDao.selectUserById(user.getId()));
        }
        return R.error("查询失败");
    }

    /**
     * 修改密码
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public R updatePassword(String token, String email, String password) {
        User user = TokenUtil.getUserFromToken(token, jedisCore);
        if (user != null) {
            userDao.changepwd(email, EncryptUtil.aesenc(key, password));
            jedisCore.del(RedisKeyConfig.TOKEN_USER + token);
            jedisCore.del(RedisKeyConfig.EMAIL_TOKEN + email);
            return R.ok("修改密码成功");
        }
        return R.error("请重新登录");

    }


    /**
     * 通过邮箱查询用户
     *
     * @param token
     * @return
     */
    @Override
    public R selectUserByEmail(String token) {
        User user = TokenUtil.getUserFromToken(token, jedisCore);
        if (user != null) {
            return R.ok(userDao.selectUserByEmail(user.getEmail()));
        }
        return R.error("查询失败");
    }

    /**
     * 判断注册时是否发过验证码
     *
     * @param email 用户邮箱
     * @return
     */
    @Override
    public R sendEmailCode(String email) {
        if (!jedisCore.checkKey(RedisKeyConfig.CODE_REGISTER + email)) {
            String code = getValidateCode(6);
            MailUtils.sendMail(email, "欢迎注册宅客微购，这是您的注册验证码：" + code,
                    "宅客微购注册验证码");

            jedisCore.set(RedisKeyConfig.CODE_REGISTER + email, code, 5 * 60);

            return R.ok("验证码发送成功");
        } else {
            return R.ok("验证码已经发送");
        }
    }

    /**
     * 判断找回密码时是否发过验证码
     *
     * @param email 用户邮箱
     * @return
     */
    @Override
    public R getEmailCode(String email) {
        if (!jedisCore.checkKey(RedisKeyConfig.CODE_FINDPASS + email)) {
            String code = getValidateCode(6);
            MailUtils.sendMail(email, "您已提交找回密码，这是您的验证码：" + code,
                    "找回密码申请");

            jedisCore.set(RedisKeyConfig.CODE_FINDPASS + email, code, 2 * 60);

            return R.ok("验证码发送成功");
        } else {
            return R.ok("验证码已经发送");
        }
    }

    /**
     * 验证用户登录是否超过有效期
     *
     * @param userToken token
     * @return
     */
    @Override
    public R checkToken(String userToken) {
        return R.ok();
    }

    /**
     * 退出登录
     *
     * @param userToken token
     * @return
     */
    @Override
    public R loginOut(String userToken) {
        //JedisCore jedisCore= jedisCore;
        if (!StringUtil.checkEmpty(userToken)){


            if(jedisCore.checkKey(RedisKeyConfig.TOKEN_USER + userToken)){

                User user = JSON.parseObject(jedisCore.get(RedisKeyConfig.TOKEN_USER + userToken), User.class);
                jedisCore.del(RedisKeyConfig.EMAIL_TOKEN + user.getEmail());
                jedisCore.del(RedisKeyConfig.TOKEN_USER + userToken);
                //JedisUtil.closeJedis(jedisCore.getJedis());
                return R.ok();
            } else {
                //JedisUtil.closeJedis(jedisCore.getJedis());
                return R.error("令牌已失效");
            }

        } else {
            //JedisUtil.closeJedis(jedisCore.getJedis());
            return R.error("请传递令牌");
        }

    }

    /**
     * 修改用户信息
     *
     * @param token
     * @param updateUserDto
     * @return
     */
    @Override
    public R updateUser(String token, UpdateUserDto updateUserDto) {
        User user1 = TokenUtil.getUserFromToken(token, jedisCore);
        if (user1 != null) {
            updateUserDto.setId(user1.getId());
            userDao.updateUser(updateUserDto);
            return R.ok("更新成功");
        }
        return R.error("更新失败");
    }
}
