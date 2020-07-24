package com.qf.service;

import com.qf.vo.R;

public interface ShopService {
    //查询所有商品信息
     R queryByStoreId(Integer storeId);

     //根据商品编号查询商品信息
    R queryById(Integer id);
}
