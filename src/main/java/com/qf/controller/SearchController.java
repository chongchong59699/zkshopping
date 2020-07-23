package com.qf.controller;

import com.qf.dto.SearchGoodsInStoreDto;
import com.qf.service.SearchService;
import com.qf.vo.R;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: zkshopping
 * @description:
 * @encoder: Roue(赵鸿宇)
 * @create: 2020-07-18 18:31
 **/
@CrossOrigin
@Api(value = "用于搜索列表")
@RestController
@RequestMapping("api/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "获取所有品牌",notes = "获取所有品牌的logo以及商店id")
    @GetMapping("getAllBand")
    public R getAllBand(){
        return searchService.getAllBand();
    }

    @ApiOperation(value = "通过商店名获取商店信息",notes = "通过商店名获取商店信息，用于展示商店详情")
    @GetMapping("getStoreByName")
    public R getStoreByName(String storeName){
        return searchService.getStoreByName(storeName);
    }

    @ApiOperation(value = "通过关键字在店铺内搜索商品",notes = "通过关键字在店铺内搜索商品，主要用于商品搜索中的搜索商家")

    @PostMapping("searchGoodsInStore")
    public R searchGoodsInStore(@RequestBody SearchGoodsInStoreDto searchGoodsInStoreDto){
        return searchService.searchGoodsInStore(searchGoodsInStoreDto);
    }

}
