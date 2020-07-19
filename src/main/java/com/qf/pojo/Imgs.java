package com.qf.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-qf-pojo-Imgs")
@Data
public class Imgs implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "图片编号")
    private Integer id;

    /**
     * 图片链接
     */
    @ApiModelProperty(value = "图片链接")
    private String url;

    /**
     *
     */
    @ApiModelProperty(value = "商品编号")
    private Integer goods_id;

    private static final long serialVersionUID = 1L;
}

