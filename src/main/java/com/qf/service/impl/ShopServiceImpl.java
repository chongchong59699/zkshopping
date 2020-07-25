package com.qf.service.impl;

import com.qf.dao.ShopDao;
import com.qf.service.ShopService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao dao;



    @Override
    public R queryByStoreId(Integer storeId) {
        return R.ok(dao.queryByStoreId(storeId));
    }

    @Override
    public R queryById(Integer id) {
        return R.ok(dao.queryById(id));
    }
}
