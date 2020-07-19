package com.qf.service;

import com.qf.dto.LoginUserDto;
import com.qf.dto.RegisterUserDto;
import com.qf.vo.R;

/**
 * @author: Sophia
 * @date: 2020/7/18
 */
public interface UserService {

    /**
     * 校验手机号
     * @param phone 手机号
     * @return
     */
    R checkPhone(String phone);

    /**
     * 校验邮箱
     * @param email 邮箱
     * @return
     */
    R checkEmail(String email);

    /**
     * 添加用户
     *
     * @param registerUserDto 用户注册信息
     * @return
     */
    R addUser(RegisterUserDto registerUserDto);

    /**
     * 用户登录
     *
     * @param loginUserDto 用户登录信息
     * @return
     */
    R userLogin(LoginUserDto loginUserDto);

    /**
     * 忘记密码，用来找回密码
     *
     * @param loginUserDto 用户登录信息
     * @return
     */
    R findPassword(LoginUserDto loginUserDto);
}
