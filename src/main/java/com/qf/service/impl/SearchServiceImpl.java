package com.qf.service.impl;

import com.qf.dao.SearchMapper;
import com.qf.dto.BandDto;
import com.qf.dto.SearchGoodsInStoreDto;
import com.qf.pojo.Goods;
import com.qf.pojo.Store;
import com.qf.service.SearchService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: zkshopping
 * @description:
 * @encoder: Roue(赵鸿宇)
 * @create: 2020-07-18 20:52
 **/
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;


    @Override
    public R getAllBand() {
        List<BandDto> allBand = searchMapper.getAllBand();
        if (allBand != null) {
            return R.ok(allBand);
        }
        return R.error("数据库为空");
    }

    @Override
    public R getStoreByName(String storeName) {
        Store storeByName = searchMapper.getStoreByName(storeName);
        if (storeByName != null) {
            return R.ok(storeByName);
        }
        return R.error("店铺名字有误，或店铺不存在");
    }

    @Override
    public R searchGoodsInStore(SearchGoodsInStoreDto searchGoodsInStoreDto) {
        List<Goods> goodsInStoreByKey = searchMapper.selectGoodsInStoreByKey(searchGoodsInStoreDto);
        if (goodsInStoreByKey != null) {
            return R.ok(goodsInStoreByKey);
        }
        return R.error("本店暂无该商品");
    }
}
