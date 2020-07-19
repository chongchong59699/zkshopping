package com.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qf.config.RedisKeyConfig;
import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.util.BeanUtil;
import com.qf.util.EncryptUtil;
import com.qf.util.JedisCore;
import com.qf.util.MailUtils;
import com.qf.vo.R;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userdao;
    @Autowired
    private JedisCore jedisCore;
    @Value("${zkwg.aes.passkey}")
    public String key;

    /**
     * 查看用户信息
     *
     * @param id
     * @return
     */
    @Override
    public R selectUserById(int id) {
        return R.ok(userdao.selectUserById(id));
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
        List<User> users = userdao.selectUserByEmail(email);
        System.out.println(users);
        if (users != null) {
            MailUtils.sendMail("957162996@qq.com", "你好，这是一封测试邮件，无需回复。", "测试邮件随机生成的验证码是：" + MailUtils.getValidateCode(6));
            int changepwd = userdao.changepwd(email, password);
            return R.ok("修改密码成功");
        }
        return R.error("请重新登录");

    }
}