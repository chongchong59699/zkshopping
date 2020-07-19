package com.qf.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-qf-pojo-UserOrderGoods")
@Data
public class UserOrderGoods implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private Integer goods_id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private Integer user_order_id;

    /**
     * 商品购买数量
     */
    @ApiModelProperty(value = "商品购买数量")
    private Integer goods_num;

    /**
     * 商品总金额
     */
    @ApiModelProperty(value = "商品总金额")
    private Double total_fee;

    private static final long serialVersionUID = 1L;
}

