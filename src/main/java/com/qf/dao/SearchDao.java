package com.qf.dao;

import com.qf.dto.BandDto;
import com.qf.dto.SearchGoodsInStoreDto;
import com.qf.pojo.Goods;
import com.qf.pojo.Store;
import com.qf.vo.R;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchDao {
    @Select("select store_id,logo_img_url from zkwg.store")
    List<BandDto> getAllBand();

    @Select("select * from zkwg.store where store_name like concat('%',#{storeName},'%')")
    Store getStoreByName(String storeName);

    List<Goods> selectGoodsInStoreByKey(SearchGoodsInStoreDto searchGoodsInStoreDto);

    @Select("select * from zkwg.goods where zkwg.goods.name like concat('%',#{key},'%')")
    List<Goods> selectGoodsByName(String key);

    @Select("select * from zkwg.store where zkwg.store.store_name like concat('%',#{key},'%')")
    List<Store> selectStoresByName(String key);
}
