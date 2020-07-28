package com.qf.dto;

import lombok.Data;

import java.util.Date;
@Data

public class UpdateUserDto {
    private Integer id;
    private String username;
    private String img_url;
    private String nickname;
    private Integer gender;
    private Date birthday;

}
