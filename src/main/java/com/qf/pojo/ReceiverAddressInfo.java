package com.qf.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value = "com-qf-pojo-ReceiverAddressInfo")
@Data
public class ReceiverAddressInfo implements Serializable {
    /**
     *
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String province;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String detailed_address;

    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    private String zip_code;

    /**
     * 收货人姓名
     */
    @ApiModelProperty(value = "收货人姓名")
    private String receiver_name;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    private Integer user_id;

    private static final long serialVersionUID = 1L;
}

