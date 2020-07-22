package com.qf.dto;

import lombok.Data;

/**
 * @author: Sophia
 * @date: 2020/7/18
 */
@Data
public class RegisterUserDto {
    private String username;
    private String nickname;
    private String password;
    private String phone;
    private String email;
    private String code;
}
