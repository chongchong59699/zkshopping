package com.qf.service;

import com.qf.vo.R;

/**
 * @Interface: OnlineStoreService
 * @Description: 首页 在线商城 1,2,3级分类业务层
 * @Author: Jerry(姜源)
 * @Create: 2020/07/18 14:40
 */
public interface GoodsInfoService {

    R queryAllGoods();

    R queryTypeLevel();

    R queryGoodsByFirstLevel();

    R queryGoodsBySecondLevel();

    R queryGoodsByThirdLevel();
}
