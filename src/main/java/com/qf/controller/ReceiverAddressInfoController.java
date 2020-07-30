package com.qf.controller;

import com.qf.annotation.TokenValidate;
import com.qf.constant.SystemConstant;
import com.qf.pojo.ReceiverAddressInfo;
import com.qf.service.ReceiverAddressInfoService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@Api(tags = "收货地址管理")
@RestController
@RequestMapping("api/ReceverAddressInfo/")
public class ReceiverAddressInfoController {
    @Autowired
    private ReceiverAddressInfoService service;

    /**
     * 通过用户编号查询收货地址
     *
     * @param uid
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "通过用户编号查询收货地址", notes = "通过用户编号查询收货地址")
    @PostMapping("selectByUid")
    public R selectByUid(HttpServletRequest request) {
        System.out.println(request);
        String token = request.getHeader(SystemConstant.TOKEN_HEADER);
        return service.selectByUid(request.getHeader(SystemConstant.TOKEN_HEADER));
    }

    /**
     * 添加收货地址
     *
     * @param receverAddressInfo
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "添加收货地址", notes = "添加收货地址")
    @PostMapping("insert")
    public R insert(HttpServletRequest request, @RequestBody ReceiverAddressInfo receverAddressInfo) {
        return service.insert(request.getHeader(SystemConstant.TOKEN_HEADER), receverAddressInfo);
    }

    /**
     * 修改收货地址
     *
     * @param receverAddressInfo
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "修改收货地址", notes = "修改收货地址")
    @PostMapping("updateAddress")
    public R updateAddress(HttpServletRequest request, @RequestBody ReceiverAddressInfo receverAddressInfo) {
        return service.updateAddress(request.getHeader(SystemConstant.TOKEN_HEADER), receverAddressInfo);
    }

    /**
     * 根据编号删除收货地址
     *
     * @param id
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "删除收货地址", notes = "删除收货地址")
    @PostMapping("deleteAddress/{id}")
    public R deleteAddress(@PathVariable int id, HttpServletRequest request) {
        return service.delete(request.getHeader(SystemConstant.TOKEN_HEADER), id);
    }

    /**
     * 根据收货地址编号查询收货信息
     *
     * @param id
     * @return
     */
    @TokenValidate
    @ApiOperation(value = "根据收货地址编号查询收货信息", notes = "根据收货地址编号查询收货信息")
    @PostMapping("selectById/{id}")
    public R selectById(@PathVariable int id, HttpServletRequest request) {
        return service.selectById(request.getHeader(SystemConstant.TOKEN_HEADER), id);
    }
}
