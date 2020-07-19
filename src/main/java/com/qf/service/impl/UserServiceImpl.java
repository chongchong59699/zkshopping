package com.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.qf.config.RedisKeyConfig;
import com.qf.dao.UserDao;
import com.qf.dto.LoginUserDto;
import com.qf.dto.RegisterUserDto;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.util.*;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 秘钥
     */
    @Value("${zkwg.aes.passkey}")
    private String key;

    /**
     * 校验账号
     * @param phone 账号
     * @return
     */
    @Override
    public R checkPhone(String phone) {
        User user = userDao.selectUserByPhone(phone);

        if (user != null){
            return R.error("该手机号已注册！");
        } else {
            return R.ok();
        }
    }

    /**
     * 校验邮箱
     * @param email 邮箱
     * @return
     */
    @Override
    public R checkEmail(String email) {
        User user = userDao.selectUserByEmail(email);
        if (user != null){
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
        if (checkPhone(registerUserDto.getPhone()).getCode() == 200
                && checkEmail(registerUserDto.getEmail()).getCode() == 200){

            // 向注册人邮箱发送邮箱验证码
            boolean b = MailUtils.sendMail(registerUserDto.getEmail(),
                    "欢迎注册宅客微购，这是您的注册验证码", getValidateCode(6));

            // 判断验证码是否发送成功
            if (b){
                User user = new User();

                user.setUsername(registerUserDto.getUsername());
                // 将密码转换成密文
                user.setPassword(EncryptUtil.aesenc(key, registerUserDto.getPassword()));
                user.setPhone(registerUserDto.getPhone());
                user.setEmail(registerUserDto.getEmail());

                // 添加用户
                userDao.insertUser(user);

                return R.ok();

            } else {
                return R.error("未收到验证码，请重新发送");
            }

        } else {

            return R.error("注册失败，请重新操作");
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

        // 获取用户登录的账号
        String account = JudgeUtil.getPhoneOrEmail(loginUserDto).get("account");

        // 校验该用户是否被冻结
        if (jedisCore.checkKey(JudgeUtil.getPhoneOrEmail(loginUserDto).get("FOR")
                + JudgeUtil.getPhoneOrEmail(loginUserDto).get("account"))){

            return R.error("您的账号已被冻结，请" + jedisCore.ttl(JudgeUtil.getPhoneOrEmail(loginUserDto).get("FOR")
                    + JudgeUtil.getPhoneOrEmail(loginUserDto).get("account"))
                    + "秒之后登录");

        } else if(jedisCore.checkKey(JudgeUtil.getPhoneOrEmail(loginUserDto).get("TOKEN")
                + JudgeUtil.getPhoneOrEmail(loginUserDto).get("account"))){

            return R.error("您的账号已经登录啦");
        } else {
            User user = userDao.selectUser(account);
            // 登录标记
            boolean isError = true;

            if (user != null){

                    // 校验用户密码是否相等
                    if (user.getPassword().equals(EncryptUtil.aesenc(key, loginUserDto.getPassword()))){
                        // 成功登录  生成令牌 设置有效期 存储到Redis
                        String token = TokenUtil.createToken(user.getId());

                        // 存储手机号
                        jedisCore.set(JudgeUtil.getPhoneOrEmail(loginUserDto).get("TOKEN")
                                + JudgeUtil.getPhoneOrEmail(loginUserDto).get("account"), token, RedisKeyConfig.TOKEN_TIME);
                        // 存储user信息
                        jedisCore.set(RedisKeyConfig.TOKEN_USER + token, JSON.toJSONString(user), RedisKeyConfig.TOKEN_TIME);

                        // 登录成功
                        isError = false;
                        // 返回token
                        return R.ok(token);
                }

            }
            // 登录失败
            if (isError){

                // 判断10分钟内错误次数
                if (jedisCore.keys(JudgeUtil.getPhoneOrEmail(loginUserDto).get("ERROR")
                        + JudgeUtil.getPhoneOrEmail(loginUserDto).get("account")) == 2){
                    // 冻结账号，设置冻结时间，默认30分钟
                    jedisCore.set(JudgeUtil.getPhoneOrEmail(loginUserDto).get("TOKEN")
                            + JudgeUtil.getPhoneOrEmail(loginUserDto).get("account"), System.currentTimeMillis()+"",RedisKeyConfig.TOKENFOR_TIME);
                }

                // 记录本次错误，10分钟内错误3次，冻结账号10分钟
                jedisCore.set(JudgeUtil.getPhoneOrEmail(loginUserDto).get("TOKEN")
                        + JudgeUtil.getPhoneOrEmail(loginUserDto).get("account") + ":" + System.currentTimeMillis() , "", RedisKeyConfig.PHONERROR_TIME);
            }
        }

        return R.error("账号或者密码错误");
    }

    /**
     * 忘记密码，用来找回密码
     *
     * @param loginUserDto 用户登录信息
     * @return
     */
    @Override
    public R findPassword(LoginUserDto loginUserDto) {
        String account = JudgeUtil.getPhoneOrEmail(loginUserDto).get("account");

        if (userDao.updatePassword(account, EncryptUtil.aesenc(key, loginUserDto.getPassword())) > 0){
            return R.ok("密码修改成功！");
        }
        return R.error("该账号不存在！");
    }
	
	
	 /**
     * 查看用户信息
     *
     * @param id
     * @return
     */
    @Override
    public R selectUserById(int id) {
        return R.ok(userDao.selectUserById(id));
    }

    /**
     * 修改密码
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public R updatePassword(String email, String password) {
        System.out.println(email);
        User user = userDao.selectUserByEmail(email);
        System.out.println(user);
        if (user != null) {
            MailUtils.sendMail("957162996@qq.com", "你好，这是一封测试邮件，无需回复。", "测试邮件随机生成的验证码是：" + MailUtils.getValidateCode(6));
            int changepwd = userDao.changepwd(email, password);
            return R.ok("修改密码成功");
        }
        return R.error("请重新登录");

    }
}
