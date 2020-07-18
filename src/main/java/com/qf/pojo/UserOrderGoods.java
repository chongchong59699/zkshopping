package com.qf.pojo;

import lombok.Data;

@Data
public class UserOrderGoods {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private Integer product_id;

    /**
     *
     */
    private Integer user_order_id;

    /**
     *
     */
    private Integer goods_num;

    /**
     *
     */
    private Double total_fee;
}

