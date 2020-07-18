package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    List<User> selectUserById(int id);
    int changepwd(@Param("email") String email, @Param("password") String password);
    List<User> selectUserByEmail(String email);
}
