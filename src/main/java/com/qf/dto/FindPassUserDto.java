package com.qf.dto;

import lombok.Data;

/**
 * @author: Sophia
 * @date: 2020/7/18
 */
@Data
public class FindPassUserDto {
    private String username;
    private String email;
    private String password;
    private String code;
}
