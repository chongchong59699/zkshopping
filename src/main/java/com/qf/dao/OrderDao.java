package com.qf.dao;

import com.qf.dto.CommitOrderDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: OrderDao
 * @Author: 刘嘉豪
 * @Date: 2020/7/20
 * @Time: 20:27
 */
@Repository
public interface OrderDao {
    @Insert("INSERT INTO user_order  " +
            "(id,user_id,buyer_message,buyer_nickname,`status`,buyer_rate,send_method,receiver_addr_id,goods_num,payment,total_fee)  " +
            "VALUES (#{order_id} ,#{user_id} ,#{buyer_message},#{buyer_nickname} ,1,2,#{send_method} ,#{receiver_addr_id} ,#{goods_num} ,#{total_fee} ,#{total_fee})")
    int addOrder(CommitOrderDto cod);

    @Select("SELECT * FROM user_order WHERE user_id=#{userid} ")
    List<Map<String,Object>> getOrdersByUserId(int userid);
}
