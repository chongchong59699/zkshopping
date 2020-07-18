package com.qf.controller;

import com.google.gson.internal.$Gson$Preconditions;
import com.qf.constant.SystemConstant;
import com.qf.pojo.ReceverAddressInfo;
import com.qf.service.ReceverAddressInfoService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "收货地址管理")
@RestController
@RequestMapping("api/ReceverAddressInfo/")
public class ReceverAddressInfoController {
    @Autowired
    private ReceverAddressInfoService service;

    @PostMapping("selectByUid/{uid}")
    public R selectByUid(@PathVariable int uid) {
        return service.selectByUid(uid);
    }

    @PostMapping("insert")
    public R insert(ReceverAddressInfo receverAddressInfo) {
        return R.ok(service.insert(receverAddressInfo));
    }
}
