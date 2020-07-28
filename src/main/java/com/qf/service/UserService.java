package com.qf.service;

import com.qf.dto.FindPassUserDto;
import com.qf.dto.LoginUserDto;
import com.qf.dto.RegisterUserDto;

import com.qf.dto.UpdateUserDto;
import com.qf.vo.R;

/**
 * @author: Sophia
 * @date: 2020/7/18
 */
public interface UserService {

    /**
     * 校验手机号
     *
     * @param phone 手机号
     * @return
     */
    R checkPhone(String phone);

    /**
     * 校验邮箱
     *
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
     * @param findPassUserDto 找回密码时用户信息
     * @return
     */
    R findPassword(FindPassUserDto findPassUserDto);

    R selectUserById(String token);

    R updatePassword(String token,String email, String password);
    R selectUserByEmail(String token);

    /**
     * 判断注册时是否发过验证码
     *
     * @param email 用户邮箱
     * @return
     */
    R sendEmailCode(String email);

    /**
     * 判断找回密码时是否发过验证码
     *
     * @param email 用户邮箱
     * @return
     */
    R getEmailCode(String email);

    /**
     * 验证用户登录是否超过有效期
     *
     * @param userToken token
     * @return
     */
    R checkToken(String userToken);

    /**
     * 退出登录
     *
     * @param userToken token
     * @return
     */
    R loginOut(String userToken);

    /**
     * 更新用户信息
     * @param token
     * @param updateUserDto
     * @return
     */
    R updateUser(String token, UpdateUserDto updateUserDto);
}
