package com.qf.dao;

import com.qf.dto.BandDto;
import com.qf.dto.SearchGoodsInStoreDto;
import com.qf.pojo.Goods;
import com.qf.pojo.Store;
import com.qf.vo.R;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchMapper {
    List<BandDto> getAllBand();

    Store getStoreByName(String storeName);

    List<Goods> selectGoodsInStoreByKey(SearchGoodsInStoreDto searchGoodsInStoreDto);
}
