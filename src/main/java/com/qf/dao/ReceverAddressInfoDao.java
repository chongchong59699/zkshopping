package com.qf.dao;

import com.qf.pojo.ReceverAddressInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceverAddressInfoDao {
    List<ReceverAddressInfo> selectByUid(int id);

    int insert(ReceverAddressInfo receverAddressInfo);

    int update(ReceverAddressInfo receverAddressInfo);
    int delete(int id);
}
