package com.qf.dto;

import lombok.Data;

@Data
/**
 * 显示店铺里的商品列表
 */
public class ShopDto {
    private Integer id;
    private String url;

    /**
     * 新增店铺 id 映射，通过商品id可以查询到店铺id
     * By：jiang yuan
     * Time：2020-7-25 10:34:59
     */
    private Integer store_id;

    private String name;
    private Double price;
    private String store_name;
    private String logo_img_url;
    private String wangwang;
    private String third_level_name;

}
