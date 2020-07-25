package com.qf.dto;

import lombok.Data;

import java.util.List;

/**
 * @Class: Lev2TypeDto
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/07/20 10:13
 */
@Data
public class Lev2TypeDto {
    private Integer id;
    private String name;

    private List<Lev3TypeDto> lev3TypeDtoList;
    private List<GoodsDto> goodsDtoList;
}
