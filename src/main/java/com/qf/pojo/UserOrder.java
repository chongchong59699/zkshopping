package com.qf.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserOrder {
    /**
     *
     */
    private String id;

    /**
     *
     */
    private Double payment;

    /**
     * 支付类型 1在线支付 2货到付款
     */
    private Integer payment_type;

    /**
     *
     */
    private Double post_fee;

    /**
     * 状态 1未付款 2已付款 3未发货 4已发货 5交易成功 6交易关闭
     */
    private Integer status;

    /**
     * @JsonFormat 作为 json 输出的时间格式
     * @DateTimeFormat 作为 对象 输入的时间格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    /**
     * @JsonFormat 作为 json 输出的时间格式
     * @DateTimeFormat 作为 对象 输入的时间格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uodate_time;

    /**
     * @JsonFormat 作为 json 输出的时间格式
     * @DateTimeFormat 作为 对象 输入的时间格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payment_time;

    /**
     * @JsonFormat 作为 json 输出的时间格式
     * @DateTimeFormat 作为 对象 输入的时间格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date consign_time;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end_time;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date close_time;

    /**
     *
     */
    private Integer user_id;

    /**
     *
     */
    private String buyer_message;

    /**
     *
     */
    private String buyer_nickname;

    /**
     * 1未评价 2已评价
     */
    private Integer buyer_rate;

    /**
     * 1送货上门 2快递包邮
     */
    private Integer send_method;
}

