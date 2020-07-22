package com.qf.controller;

import com.qf.service.ShopService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Api(tags = "商家店铺相关接口")
@RequestMapping("api/shopController/")
public class ShopController {
    @Autowired
    private ShopService service;


    @ApiOperation("获取店铺所有商品信息")
    @GetMapping("queryAll")
    public R queryAll(){
        return service.queryAll();
    }

    @ApiOperation("根据商品编号查询商品信息")
    @GetMapping("queryById/{id}")
    public R rueryById(@PathVariable Integer id){
        return service.queryById(id);
    }
}
