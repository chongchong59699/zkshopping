package com.qf.service.impl;

import com.qf.constant.SystemConstant;
import com.qf.dao.GoodsInfoDao;
import com.qf.dto.*;
import com.qf.service.GoodsInfoService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Class: OnlineStoreServiceImpl
 * @Description:
 * @Author: Jerry(姜源)
 * @Create: 2020/07/18 14:59
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Autowired
    private GoodsInfoDao dao;

    /**
     * 查询包含所有分类的商品
     * @return
     */
    @Override
    public R queryAllGoods() {
        List<Lev1TypeDto> allGoodsList = dao.queryAllGoods();
        if (allGoodsList.size() > 0) {
            return R.ok(allGoodsList);
        }
        return R.error(SystemConstant.QUERY_NULL);
    }

    /**
     * 查询三级分类信息
     * @return
     */
    @Override
    public R queryTypeLevel() {
        List<Lev1TypeDto> levelsList = dao.queryGoodsType();
        if (levelsList.size() > 0) {
            System.out.println("levelsList = " + levelsList);
            return R.ok(levelsList);
        }
        return R.error(SystemConstant.QUERY_NULL);
    }

    /**
     * 查询一级分类商品信息
     * @return
     */
    @Override
    public R queryGoodsByFirstLevel(Integer id) {
        List<GoodsDto> lev1TypeDtoList = dao.queryGoodsByFirstLevel(id);
        if (lev1TypeDtoList.size() > 0) {
            return R.ok(lev1TypeDtoList);
        }
        return R.error(SystemConstant.QUERY_NULL);
    }

    /**
     * 查询二级分类商品信息
     * @return
     */
    @Override
    public R queryGoodsBySecondLevel(Integer id) {
        List<GoodsDto> lev2TypeDtoList = dao.queryGoodsBySecondLevel(id);
        if (lev2TypeDtoList.size() > 0) {
            return R.ok(lev2TypeDtoList);
        }
        return R.error(SystemConstant.QUERY_NULL);
    }

    /**
     * 查询三级分类商品信息
     * @return
     */
    @Override
    public R queryGoodsByThirdLevel(Integer id) {
        List<GoodsDto> lev3TypeDtoList = dao.queryGoodsByThirdLevel(id);
        if (lev3TypeDtoList.size() > 0) {
            return R.ok(lev3TypeDtoList);
        }
        return R.error(SystemConstant.QUERY_NULL);
    }

}
