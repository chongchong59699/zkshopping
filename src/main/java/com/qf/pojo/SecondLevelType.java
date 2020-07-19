package com.qf.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-qf-pojo-SecondLevelType")
@Data
public class SecondLevelType implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 二级分类名称
     */
    @ApiModelProperty(value = "二级分类名称")
    private String name;

    /**
     * 一级分类表编号
     */
    @ApiModelProperty(value = "一级分类表编号")
    private Integer first_level_id;

    private static final long serialVersionUID = 1L;
}

