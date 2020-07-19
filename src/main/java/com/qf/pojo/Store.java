package com.qf.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-qf-pojo-Store")
@Data
public class Store implements Serializable {
    /**
     * 店铺编号
     */
    @ApiModelProperty(value = "店铺编号")
    private Integer store_id;

    /**
     * 店铺名称
     */
    @ApiModelProperty(value = "店铺名称")
    private String store_name;

    /**
     * 店铺描述
     */
    @ApiModelProperty(value = "店铺描述")
    private String description;

    /**
     * 店铺logo
     */
    @ApiModelProperty(value = "店铺logo")
    private String logo_img_url;

    /**
     * 商品描述评分 默认5
     */
    @ApiModelProperty(value = "商品描述评分 默认5")
    private Integer goods_desc_score;

    /**
     * 服务态度评分 默认5
     */
    @ApiModelProperty(value = "服务态度评分 默认5")
    private Integer service_attitude_score;

    /**
     * 物流速度评分 默认5
     */
    @ApiModelProperty(value = "物流速度评分 默认5")
    private Integer logistics_speed_score;

    /**
     * 旺旺昵称
     */
    @ApiModelProperty(value = "旺旺昵称")
    private String wangwang;

    /**
     * 1代表1个心 5个心=1个钻石 5个钻石=1个皇冠 默认值为1
     */
    @ApiModelProperty(value = "1代表1个心 5个心=1个钻石 5个钻石=1个皇冠 默认值为1")
    private Integer lavel;

    private static final long serialVersionUID = 1L;

}

