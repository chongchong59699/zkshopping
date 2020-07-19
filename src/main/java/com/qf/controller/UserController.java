package com.qf.controller;

import com.qf.constant.SystemConstant;
import com.qf.dto.LoginUserDto;
import com.qf.dto.RegisterUserDto;
import com.qf.service.UserService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author: Sophia
 * @date: 2020/7/18
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping("api/user/")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 校验手机号
     * @param phone 手机号
     * @return
     */
    @ApiOperation(value = "校验手机号是否存在", notes = "校验手机号是否存在")
    @GetMapping("checkPhone/{phone}")
    public R checkPhone(@PathVariable String phone){
        return userService.checkPhone(phone);
    }

    /**
     * 校验邮箱
     * @param email 邮箱
     * @return
     */
    @ApiOperation(value = "校验邮箱是否存在", notes = "校验邮箱是否存在")
    @GetMapping("checkEmail/{email}")
    public R checkEmail(@PathVariable String email){
        return userService.checkEmail(email);
    }

    /**
     * 用户注册
     *
     * @param registerUserDto 用户注册信息
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping("userRegister")
    public R userRegister(@RequestBody RegisterUserDto registerUserDto){
        return userService.addUser(registerUserDto);
    }

    /**
     * 用户登录
     *
     * @param loginUserDto 用户登录的账号密码
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("userLogin")
    public R userLogin(LoginUserDto loginUserDto){
        return userService.userLogin(loginUserDto);
    }

    /**
     * 忘记密码，用来找回密码
     *
     * @param loginUserDto 用户登录信息
     * @return
     */
    @ApiOperation(value = "找回密码", notes = "找回密码")
    @PostMapping("findPassword")
    public R findPassword(LoginUserDto loginUserDto){
        return userService.findPassword(loginUserDto);
    }
}
