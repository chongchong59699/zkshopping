package com.qf.dao;

import com.qf.dto.GoodsDto;
import com.qf.dto.Lev1TypeDto;
import com.qf.dto.Lev2TypeDto;
import com.qf.dto.Lev3TypeDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Interface: OnlineStoreDao
 * @Description: 首页 在线商城 1,2,3级分类控制器
 * @Author: Jerry(姜源)
 * @Create: 2020/07/18 14:42
 */
@Repository
public interface GoodsInfoDao {

    List<Lev1TypeDto> queryAllGoods();

    List<Lev1TypeDto> queryGoodsType();

    List<GoodsDto> queryGoodsByFirstLevel();

    List<GoodsDto> queryGoodsBySecondLevel();

    List<GoodsDto> queryGoodsByThirdLevel();
}
