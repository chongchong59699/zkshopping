package com.qf.controller;

import com.qf.annotation.TokenValidate;
import com.qf.constant.SystemConstant;
import com.qf.dto.FindPassUserDto;
import com.qf.dto.LoginUserDto;
import com.qf.dto.RegisterUserDto;
import com.qf.dto.UpdateUserDto;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.vo.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("api/user/")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 校验手机号
     * @param phone 手机号
     * @return
     */
    @ApiOperation(value = "校验邮箱是否存在", notes = "校验邮箱是否存在")
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
    public R userLogin(@RequestBody LoginUserDto loginUserDto){
        return userService.userLogin(loginUserDto);
    }

    /**
     * 忘记密码，用来找回密码
     *
     * @param findPassUserDto 用户登录信息
     * @return
     */
    @ApiOperation(value = "找回密码", notes = "找回密码")
    @PostMapping("findPassword")
    public R findPassword(@RequestBody FindPassUserDto findPassUserDto){
        return userService.findPassword(findPassUserDto);
    }
	
	/**
     * 通过用户编号查询用户
     * @param request
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "查询用户通过用户编号", notes = "查询用户通过用户编号")
    @PostMapping("selectUserById")
    public R selectUserById(HttpServletRequest request) {
        return userService.selectUserById(request.getHeader(SystemConstant.TOKEN_HEADER));
    }
	
	/**
     * 修改密码
     * @param email
     * @param password
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "修改密码-任晓雨", notes = "通过邮箱修改密码")
    @PostMapping("changePassword/{password}")
    public R changePassword(HttpServletRequest request,String email, @PathVariable String password) {
        return userService.updatePassword(request.getHeader(SystemConstant.TOKEN_HEADER),email, password);
    }

    /**
     * 通过邮箱查询用户
     * @param request
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "通过邮箱查询用户", notes = "通过邮箱查询用户")
    @PostMapping("selectUserByEmail")
    public R selectUserByEmail(HttpServletRequest request) {
        return userService.selectUserByEmail(request.getHeader(SystemConstant.TOKEN_HEADER));
}

    /**
     * 判断注册时是否发过验证码
     *
     * @param email 用户邮箱
     * @return
     */
    @ApiOperation(value = "注册验证码", notes = "注册验证码")
    @PostMapping("sendEmailCode/{email}")
    public R sendEmailCode(@PathVariable String email){
        return userService.sendEmailCode(email);
    }

    /**
     * 判断找回密码时是否发过验证码
     *
     * @param email 用户邮箱
     * @return
     */
    @ApiOperation(value = "找回密码验证码", notes = "找回密码验证码")
    @PostMapping("getEmailCode/{email}")
    public R getEmailCode(@PathVariable String email){
        return userService.getEmailCode(email);
    }

    /**
     * 验证用户登录是否超过有效期
     *
     * @param request 请求消息头
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "验证登录有效期", notes = "验证登录有效期")
    @GetMapping("checkUserToken")
    public R checkUserToken(HttpServletRequest request){
        return userService.checkToken(request.getHeader(SystemConstant.TOKEN_HEADER));
    }

    /**
     * 退出登录
     *
     * @param request 请求消息头
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "退出账号", notes = "退出账号")
    @GetMapping("loginOut")
    public R loginOut(HttpServletRequest request){

        return userService.loginOut(request.getHeader(SystemConstant.TOKEN_HEADER));
    }

    /**
     *修改用户信息
     * @param request
     * @param updateUserDto
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @PostMapping("updateUser")
    public R updateUser(HttpServletRequest request, @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(request.getHeader(SystemConstant.TOKEN_HEADER),updateUserDto);
    }

}
