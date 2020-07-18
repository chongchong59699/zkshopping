package com.qf.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-qf-pojo-Goods")
@Data
public class Goods implements Serializable {
    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private Integer id;

    /**
     * 商品编码（生成）
     */
    @ApiModelProperty(value = "商品编码（生成）")
    private String goods_code;

    /**
     * 商品图片表编号
     */
    @ApiModelProperty(value = "商品图片表编号")
    private String img_id;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格")
    private Double price;

    /**
     * 折扣率
     */
    @ApiModelProperty(value = "折扣率")
    private Double discount;

    /**
     * 店铺编号
     */
    @ApiModelProperty(value = "店铺编号")
    private Integer store_id;

    /**
     * 三级商品类型编号
     */
    @ApiModelProperty(value = "三级商品类型编号")
    private Integer third_level_id;

    /**
     * 商品广告语
     */
    @ApiModelProperty(value = "商品广告语")
    private String slogan;

    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String description;

    /**
     * 商品评分（1-5颗星）
     */
    @ApiModelProperty(value = "商品评分（1-5颗星）")
    private Integer score;

    /**
     * 评价表编号
     */
    @ApiModelProperty(value = "评价表编号")
    private Integer comment_id;

    /**
     * 库存数量
     */
    @ApiModelProperty(value = "库存数量")
    private Integer storage_num;

    /**
     * 商品型号
     */
    @ApiModelProperty(value = "商品型号")
    private String size;

    /**
     * 商品颜色
     */
    @ApiModelProperty(value = "商品颜色")
    private String color;

    private static final long serialVersionUID = 1L;
}

