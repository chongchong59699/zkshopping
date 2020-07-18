package com.qf.service;

import com.qf.pojo.User;
import com.qf.vo.R;
import org.springframework.stereotype.Repository;


public interface UserService {
    R selectUserById(int id);
    R updatePassword(String email,String password);

}
