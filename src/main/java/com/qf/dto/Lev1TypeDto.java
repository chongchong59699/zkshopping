package com.qf.dto;

import lombok.Data;

import java.util.List;

/**
 * @Class: Lev1TypeDto
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/07/20 10:13
 */
@Data
public class Lev1TypeDto {
    private Integer id;
    private String name;

    private List<Lev2TypeDto> lev2TypeDtoList;
}
