package com.qf.controller;

import com.qf.pojo.ReceiverAddressInfo;
import com.qf.service.ReceiverAddressInfoService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(tags = "收货地址管理")
@RestController
@RequestMapping("api/ReceverAddressInfo/")
public class ReceiverAddressInfoController {
    @Autowired
    private ReceiverAddressInfoService service;

    /**
     * 通过用户编号查询收货地址
     * @param uid
     * @return
     */
    @ApiOperation(value = "通过用户编号查询收货地址" ,notes = "通过用户编号查询收货地址")
    @PostMapping("selectByUid/{uid}")
    public R selectByUid(@PathVariable int uid) {
        return service.selectByUid(uid);
    }

    /**
     * 添加收货地址
     * @param receverAddressInfo
     * @return
     */
    @ApiOperation(value = "添加收货地址",notes = "添加收货地址")
    @PostMapping("insert")
    public R insert(ReceiverAddressInfo receverAddressInfo) {
        return service.insert(receverAddressInfo);
    }

    /**
     * 修改收货地址
     * @param receverAddressInfo
     * @return
     */
    @ApiOperation(value = "修改收货地址",notes = "修改收货地址")
    @PostMapping("updateAddress")
    public R updateAddress(ReceiverAddressInfo receverAddressInfo) {
        return service.updateAddress(receverAddressInfo);
    }

    /**
     * 根据编号删除收货地址
     * @param id
     * @return
     */
    @ApiOperation(value = "删除收货地址",notes = "删除收货地址")
    @PostMapping("deleteAddress/{id}")
    public R deleteAddress(@PathVariable int id){
        return service.delete(id);
    }
/**
* 根据收货地址编号查询收货信息
* @param id
* @return
*
*/
    @ApiOperation(value = "根据收货地址编号查询收货信息",notes = "根据收货地址编号查询收货信息")
    @PostMapping("selectById/{id}")
    public R selectById(@PathVariable int id) {
        return service.selectById(id);
    }
}
