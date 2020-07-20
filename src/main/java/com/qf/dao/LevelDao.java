package com.qf.dao;

import com.qf.dto.SecondLevelDto;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LevelDao {
    //查询二级分类及其所包含的三级分类
    List<SecondLevelDto> queryLevel();

}
