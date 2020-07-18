package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@ApiModel(value = "com-qf-pojo-UserOrder")
@Data
public class UserOrder implements Serializable {
    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String id;

    /**
     * 实付金额
     */
    @ApiModelProperty(value = "实付金额")
    private Double payment;

    /**
     * 支付类型 1在线支付 2货到付款
     */
    @ApiModelProperty(value = "支付类型 1在线支付 2货到付款")
    private Integer payment_type;

    /**
     * 邮费
     */
    @ApiModelProperty(value = "邮费")
    private Double post_fee;

    /**
     * 状态 1未付款 2已付款 3未发货 4已发货 5交易成功 6交易关闭
     */
    @ApiModelProperty(value = "状态 1未付款 2已付款 3未发货 4已发货 5交易成功 6交易关闭")
    private Integer status;

    /**
     * 订单创建时间
     */
    @ApiModelProperty(value = "订单创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    /**
     * 订单更新时间
     */
    @ApiModelProperty(value = "订单更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;

    /**
     * 付款时间
     */
    @ApiModelProperty(value = "付款时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payment_time;

    /**
     * 发货时间
     */
    @ApiModelProperty(value = "发货时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date consign_time;

    /**
     * 交易完成时间
     */
    @ApiModelProperty(value = "交易完成时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end_time;

    /**
     * 交易关闭时间
     */
    @ApiModelProperty(value = "交易关闭时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date close_time;

    /**
     * 关联用户编号
     */
    @ApiModelProperty(value = "关联用户编号")
    private Integer user_id;

    /**
     * 买家留言
     */
    @ApiModelProperty(value = "买家留言")
    private String buyer_message;

    /**
     * 买家昵称
     */
    @ApiModelProperty(value = "买家昵称")
    private String buyer_nickname;

    /**
     * 1未评价 2已评价
     */
    @ApiModelProperty(value = "1未评价 2已评价")
    private Integer buyer_rate;

    /**
     * 1送货上门 2快递包邮
     */
    @ApiModelProperty(value = "1送货上门 2快递包邮")
    private Integer send_method;

    private static final long serialVersionUID = 1L;
}

