package com.qf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @program: zkshopping
 * @description: 用于在店铺范围内搜索物品
 * @encoder: Roue(赵鸿宇)
 * @create: 2020-07-19 10:48
 **/
@Data
@ApiModel(value = "SearchGoodsInStoreDto(商店内查询对象)")
public class SearchGoodsInStoreDto {

    @ApiModelProperty(value = "商店id")
    private Integer store_id;
    @ApiModelProperty(value = "查询关键字")
    private String searchKey;

}
