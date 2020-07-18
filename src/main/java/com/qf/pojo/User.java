package com.qf.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class User {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String img_url;

    /**
     *
     */
    private String nickname;

    /**
     * 性别 0女 1 男
     */
    private Integer gender;

    /**
     * 生日，sql 计算年龄
     * @JsonFormat 作为 json 输出的时间格式
     * @DateTimeFormat 作为 对象 输入的时间格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     *
     */
    private String phone;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String qq_number;

    /**
     *
     */
    private String weibo_number;

    /**
     *
     */
    private Integer address_id;

    /**
     *
     */
    private Integer appointment_id;

    /**
     *
     */
    private String order_id;

    /**
     *
     */
    private Integer cart_id;

    /**
     *
     */
    private Integer message_id;

    /**
     *
     */
    private Integer integrate_id;
}

