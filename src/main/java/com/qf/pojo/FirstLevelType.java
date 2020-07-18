package com.qf.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-qf-pojo-FirstLevelType")
@Data
public class FirstLevelType implements Serializable {
    /**
     * 商品类型编号
     */
    @ApiModelProperty(value = "商品类型编号")
    private Integer id;

    /**
     * 商品类型名称 1在线商城 2餐饮娱乐 3家政服务 4美容美发 5教育培训 6汽车房产 7家居建材 8二手市场
     */
    @ApiModelProperty(value = "商品类型名称 1在线商城 2餐饮娱乐 3家政服务 4美容美发 5教育培训 6汽车房产 7家居建材 8二手市场")
    private String name;

    private static final long serialVersionUID = 1L;
}

