package com.qf.dao;

import com.qf.dto.RegisterUserDto;
import com.qf.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @author: Sophia
 * @date: 2020/7/18
 */
@Repository
public interface UserDao {

    /**
     * 根据手机号查询用户
     *
     * @param phone 手机号
     * @return
     */
    @Select("select * from user where phone = #{phone}")
    User selectUserByPhone(@Param("phone") String phone);

    /**
     * 根据邮箱查询用户
     *
     * @param email 邮箱
     * @return
     */
    @Select("select * from user where email = #{email}")
    User selectUserByEmail(@Param("email") String email);

    /**
     * 添加用户
     *
     * @param user 用户注册信息
     * @return
     */
    @Insert("insert into user(username,password,img_url,nickname,gender,birthday,phone,email," +
            "qq_number,weibo_number,address_id,appointment_id,order_id,cart_id,message_id," +
            "integrate_id) values(#{username},#{password},#{img_url},#{nickname},#{gender}," +
            "#{birthday},#{phone},#{email},#{qq_number},#{weibo_number},#{address_id}," +
            "#{appointment_id},#{order_id},#{cart_id},#{message_id},#{integrate_id})")
    int insertUser(User user);


    User selectUser(String account);
}
