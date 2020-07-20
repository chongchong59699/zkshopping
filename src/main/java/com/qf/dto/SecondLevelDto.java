package com.qf.dto;

import lombok.Data;

import java.util.List;

@Data
public class SecondLevelDto {
    private Integer second_level_id;
    private String second_level_name;
    private List<ThirdLevelDto> list;
}
