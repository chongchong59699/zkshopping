package com.qf.dto;

import lombok.Data;

@Data
/**
 * 显示店铺里的商品列表
 */
public class ShopDto {
    private Integer id;
    private String url;
    private String name;
    private Double price;
    private String store_name;
    private String logo_img_url;
    private String wangwang;
    private String third_level_name;

}
