package com.qf.dao;

import com.qf.dto.CommitOrderDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
            "(id,user_id,goods_id,buyer_message,buyer_nickname,`status`,buyer_rate,send_method,receiver_addr_id,goods_num,payment,total_fee)  " +
            "VALUES (#{order_id} ,#{user_id} ,#{goods_id} ,#{buyer_message},#{buyer_nickname} ,1,2,#{send_method} ,#{receiver_addr_id} ,#{goods_num} ,#{total_fee} ,#{total_fee})")
    int addOrder(CommitOrderDto cod);

    @Select("SELECT * FROM user_order WHERE user_id=#{userid} ")
    List<Map<String,Object>> getOrdersByUserId(int userid);

    @Update("update user_order   " +
            "set `status`=2,create_time=#{gmt_create},payment_time=#{gmt_payment}  " +
            "where `status`=1 and id= #{out_trade_no}")
    int updateOrderStatus(@Param("out_trade_no") String out_trade_no,@Param("gmt_create") String gmt_create,@Param("gmt_payment") String gmt_payment);

    @Select("select * from user_order where id= #{orderId} and user_id= #{userId}")
    Map<String,Object> getOrderByOrderId(@Param("orderId") String orderId,@Param("userId")int userId);
}
