package com.qf.controller;

import com.qf.service.GoodsInfoService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class: OnlieStoreTypeController
 * @Description: 首页 在线商城 1,2,3级分类控制器
 * @Author: Jerry(姜源)
 * @Create: 2020/07/18 14:32
 */
@Api(tags = "在线商城控制器")
@RestController
@RequestMapping("/api/goodsInfo")
public class GoodsInfoController {

    @Autowired
    private GoodsInfoService service;

    @ApiOperation(value = "查询所有商品", notes = "查询所有商品，包含一级、二级、三级分类")
    @GetMapping("/allGoods")
    public R queryAllGoods() {
        return service.queryAllGoods();
    }

    /**
     * 主导航商品分类信息
     * @return
     */
    @ApiOperation(value = "查询商品分类信息", notes = "查询商品所有分类信息名称")
    @GetMapping("/level")
    public R queryTypeLevel() {
        return service.queryTypeLevel();
    }

    /**
     * 一级分类商品信息
     * @return
     */
    @ApiOperation(value = "查询一级分类商品信息", notes = "首页展示的商品信息（一级分类+包含的商品）")
    @GetMapping("/lev1goods")
    public R queryGoodsByFirstLevel() {
        return service.queryGoodsByFirstLevel();
    }

    /**
     * 二级分类商品信息
     * @return
     */
    @ApiOperation(value = "查询二级分类商品信息", notes = "首页展示的商品信息（二级分类+包含的商品）")
    @GetMapping("/lev2goods")
    public R queryGoodsBySecondLevel() {
        return service.queryGoodsBySecondLevel();
    }

    /**
     * 三级分类商品信息
     * @return
     */
    @ApiOperation(value = "查询三级分类商品信息", notes = "首页展示的商品信息（三级分类+包含的商品）")
    @GetMapping("/lev3goods")
    public R queryGoodsByThirdLevel() {
        return service.queryGoodsByThirdLevel();
    }

}
