package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@ApiModel(value = "com-qf-pojo-User")
@Data
public class User implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String img_url;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 性别 0女 1 男
     */
    @ApiModelProperty(value = "性别 0女 1 男")
    private Integer gender;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * QQ号码
     */
    @ApiModelProperty(value = "QQ号码")
    private String qq_number;

    /**
     * 微博号码
     */
    @ApiModelProperty(value = "微博号码")
    private String weibo_number;

    /**
     * 地址编号
     */
    @ApiModelProperty(value = "地址编号")
    private Integer address_id;

    /**
     * 预约编号
     */
    @ApiModelProperty(value = "预约编号")
    private Integer appointment_id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String order_id;

    /**
     * 购物车编号
     */
    @ApiModelProperty(value = "购物车编号")
    private Integer cart_id;

    /**
     * 消息中心编号
     */
    @ApiModelProperty(value = "消息中心编号")
    private Integer message_id;

    /**
     * 积分编号
     */
    @ApiModelProperty(value = "积分编号")
    private Integer integrate_id;

    private static final long serialVersionUID = 1L;
}

