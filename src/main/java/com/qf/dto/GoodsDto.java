package com.qf.dto;

import lombok.Data;

/**
 * @Class: GoodsDto
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/07/20 10:11
 */
@Data
public class GoodsDto {
    private Integer id;
    private String goods_code;
    private String img_id;
    private String url;
    private String name;
    private String slogan;
    private Double price;
    private Double discount;
    private Integer score;
    private String size;
    private String color;

    /**
     * 新增商品所属商店信息映射
     */
    private String store_name;

    /**
     * 同时拥有三级分类的 id 用于vue渲染
     */
    private Integer lev1_id;
    private Integer lev2_id;
    private Integer lev3_id;

    private Lev3TypeDto lev3TypeDto;
}
