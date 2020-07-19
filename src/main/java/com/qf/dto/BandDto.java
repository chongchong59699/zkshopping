package com.qf.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: zkshopping
 * @description: 品牌类型对象，包含有store_id、logo_img_url
 * @encoder: Roue(赵鸿宇)
 * @create: 2020-07-18 20:53
 **/
@Data
@ApiModel(value = "品牌")
public class BandDto {
    @ApiModelProperty(value = "商店id")
    private Integer store_id;
    @ApiModelProperty(value = "商店logo图片地址")
    private String logo_img_url;

}
