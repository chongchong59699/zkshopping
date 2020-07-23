package com.qf.dto;

import lombok.Data;

/**
 * @ClassName: CommitOrderDto
 * @Author: 刘嘉豪
 * @Date: 2020/7/20
 * @Time: 18:55
 */
@Data
public class CommitOrderDto {
   private String order_id;  //后台拿
   private Integer user_id;
   private String buyer_message;
   private String buyer_nickname;  //后台数据库查询
   //private Integer status; //不要
   //private Integer buyer_rate; //不要
   private Integer send_method;
   private Integer receiver_addr_id;
   private Integer goods_num;
   private Double total_fee;
   private String goods_id;




}
