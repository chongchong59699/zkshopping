package com.qf.controller;

import com.qf.constant.SystemConstant;
import com.qf.service.UserService;
import com.qf.util.JedisCore;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags = "宅客微购个人资料")
@RequestMapping("api/user/")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private JedisCore jedisCore;

    @PostMapping("selectUserById")
    public R selectUserById(int id) {
        return R.ok(service.selectUserById(id));
    }

    @PostMapping("changePassword/{password}")
    public R changePassword(String email, @PathVariable String password) {
        System.out.println(email);
        return R.ok(service.updatePassword(email,password));

    }
}
