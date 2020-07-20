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
    private String name;
    private String slogan;
    private Double price;
    private Double discount;
    private Integer score;
    private String size;
    private String color;

    private Lev3TypeDto lev3TypeDto;
}
