package com.qf.service.impl;

import com.qf.constant.SystemConstant;
import com.qf.dao.GoodsInfoDao;
import com.qf.dto.GoodsInfoDto;
import com.qf.dto.GoodsTypeDto;
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
     * 查询三级分类信息
     * @return
     */
    @Override
    public R queryTypeLevel() {
        List<GoodsTypeDto> goodsTypeDtoList = dao.queryGoodsType();
        if (goodsTypeDtoList.size() > 0) {
            return R.ok(goodsTypeDtoList);
        }
        return R.error(SystemConstant.QUERY_NULL);
    }

    /**
     * 查询一级分类商品信息
     * @return
     */
    @Override
    public R queryGoodsByFirstLevel() {
        List<GoodsInfoDto> productInfoDtoList = dao.queryGoodsByFirstLevel();
        if (productInfoDtoList.size() > 0) {
            return R.ok(productInfoDtoList);
        }
        return R.error(SystemConstant.QUERY_NULL);
    }

    /**
     * 查询二级分类商品信息
     * @return
     */
    @Override
    public R queryGoodsBySecondLevel() {
        List<GoodsInfoDto> productInfoDtoList = dao.queryGoodsBySecondLevel();
        if (productInfoDtoList.size() > 0) {
            return R.ok(productInfoDtoList);
        }
        return R.error(SystemConstant.QUERY_NULL);
    }

    /**
     * 查询三级分类商品信息
     * @return
     */
    @Override
    public R queryGoodsByThirdLevel() {
        List<GoodsInfoDto> productInfoDtoList = dao.queryGoodsByThirdLevel();
        if (productInfoDtoList.size() > 0) {
            return R.ok(productInfoDtoList);
        }
        return R.error(SystemConstant.QUERY_NULL);
    }

}
