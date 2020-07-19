package com.qf.dao;

import com.qf.dto.GoodsInfoDto;
import com.qf.dto.GoodsTypeDto;
import org.apache.ibatis.annotations.Select;
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

    @Select("SELECT lev1.`name` AS 'lev1_name', lev2.`name` AS 'lev2_name', lev3.`name` AS 'lev3_name'" +
            " FROM first_level_type AS lev1" +
            " LEFT JOIN second_level_type AS lev2 ON lev1.`id`=lev2.`first_level_id`" +
            " LEFT JOIN third_level_type AS lev3 ON lev2.`id`=lev3.`secone_level_id`" +
            " ORDER BY lev1.`id`")
    List<GoodsTypeDto> queryGoodsType();

    @Select("SELECT g.`id`, g.`goods_code`, g.`img_id`, g.`name`, g.`slogan`, g.`price`, g.`discount`, g.`score`, lev1.`name` AS 'level_name'" +
            " FROM goods AS g" +
            " LEFT JOIN third_level_type AS lev3 ON g.`third_level_id`=lev3.`id`" +
            " LEFT JOIN second_level_type AS lev2 ON lev3.`secone_level_id`=lev2.`id`" +
            " LEFT JOIN first_level_type AS lev1 ON lev2.`first_level_id`=lev1.`id`" +
            " ORDER BY g.`id`")
    List<GoodsInfoDto> queryGoodsByFirstLevel();

    @Select("SELECT g.`id`, g.`goods_code`, g.`img_id`, g.`name`, g.`slogan`, g.`price`, g.`discount`, g.`score`, lev2.`name` AS 'level_name'" +
            " FROM goods AS g" +
            " LEFT JOIN third_level_type AS lev3 ON g.`third_level_id`=lev3.`id`" +
            " LEFT JOIN second_level_type AS lev2 ON lev3.`secone_level_id`=lev2.`id`" +
            " LEFT JOIN first_level_type AS lev1 ON lev2.`first_level_id`=lev1.`id`" +
            " ORDER BY g.`id`")
    List<GoodsInfoDto> queryGoodsBySecondLevel();

    @Select("SELECT g.`id`, g.`goods_code`, g.`img_id`, g.`name`, g.`slogan`, g.`price`, g.`discount`, g.`score`, lev3.`name` AS 'level_name'" +
            " FROM goods AS g" +
            " LEFT JOIN third_level_type AS lev3 ON g.`third_level_id`=lev3.`id`" +
            " LEFT JOIN second_level_type AS lev2 ON lev3.`secone_level_id`=lev2.`id`" +
            " LEFT JOIN first_level_type AS lev1 ON lev2.`first_level_id`=lev1.`id`" +
            " ORDER BY g.`id`")
    List<GoodsInfoDto> queryGoodsByThirdLevel();
}
