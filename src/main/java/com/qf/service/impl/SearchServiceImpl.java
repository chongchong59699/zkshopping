package com.qf.service.impl;

import com.qf.dao.SearchDao;
import com.qf.dto.BandDto;
import com.qf.dto.SearchGoodsInStoreDto;
import com.qf.pojo.Goods;
import com.qf.pojo.Store;
import com.qf.service.SearchService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: zkshopping
 * @description:
 * @encoder: Roue(赵鸿宇)
 * @create: 2020-07-18 20:52
 **/
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;


    @Override
    public R getAllBand() {
        List<BandDto> allBand = searchDao.getAllBand();
        if (allBand != null) {
            return R.ok(allBand);
        }
        return R.error("数据库为空");
    }

    @Override
    public R getStoreByName(String storeName) {
        Store storeByName = searchDao.getStoreByName(storeName);
        if (storeByName != null) {
            return R.ok(storeByName);
        }
        return R.error("店铺名字有误，或店铺不存在");
    }

    @Override
    public R searchGoodsInStore(SearchGoodsInStoreDto searchGoodsInStoreDto) {
        List<Map<String,Object>> goodsInStoreByKey = searchDao.selectGoodsInStoreByKey2(searchGoodsInStoreDto);
        if (goodsInStoreByKey != null) {
            return R.ok(goodsInStoreByKey);
        }
        return R.error("本店暂无该商品");
    }

    @Override
    public R searchGoods(String key) {
        if (key != null && !key.equals("")) {
            List<Map<String,Object>> goods = searchDao.selectGoodsByName(key);
            return R.ok(goods);
        }
        return R.error("暂时找不到该商品");
    }

    @Override
    public R searchStore(String key) {
        if (key != null && !key.equals("")) {
            List<Store> stores = searchDao.selectStoresByName(key);
            return R.ok(stores);
        }
        return R.error("该店铺不存在");
    }

    @Override
    public R getStoreById(Integer storeId) {
        if (storeId != null) {
            Store store = searchDao.getStoreById(storeId);
            return R.ok(store);
        }
        return R.error("商店id为空");

    }
}
