package com.qf.service;

import com.qf.dto.SearchGoodsInStoreDto;
import com.qf.vo.R;

import java.util.List;

public interface SearchService {

    R getAllBand();

    R getStoreByName(String storeName);

    R searchGoodsInStore(SearchGoodsInStoreDto searchGoodsInStoreDto);

    R searchGoods(String key);

    R searchStore(String key);

    R getStoreById(Integer storeId);

    R searchByTypeId(Integer typeId);
}
