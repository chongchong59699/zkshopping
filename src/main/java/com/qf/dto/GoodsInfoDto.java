package com.qf.dto;

import lombok.Data;

/**
 * @Class: ProductInfoDto
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/07/18 16:14
 */
@Data
public class GoodsInfoDto {

    /**
     * 三级 or 二级 or 一级分类名
     */
    private String level_name;

    /**
     * 以下为 goods 封装属性信息
     */
    private Integer id;

    private String goods_code;

    private String img_id;

    private String name;

    private Double price;

    private Double discount;

    private String slogan;

    private Integer score;

    private String size;

    private String color;
}
