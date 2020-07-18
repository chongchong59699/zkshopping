package com.qf.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-qf-pojo-ThirdLevelType")
@Data
public class ThirdLevelType implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 三级分类名称
     */
    @ApiModelProperty(value = "三级分类名称")
    private String name;

    /**
     * 二级分类编号
     */
    @ApiModelProperty(value = "二级分类编号")
    private Integer secone_level_id;

    private static final long serialVersionUID = 1L;
}

