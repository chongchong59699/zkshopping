package com.qf.dao;

import com.qf.dto.ShopDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopDao {

    //普通查询，查询出所有商品信息
    List<ShopDto> queryAll();
    //根据商品编号查询商品信息
    ShopDto queryById(Integer id);
}
