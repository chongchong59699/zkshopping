package com.qf.dao;

import com.qf.pojo.ReceiverAddressInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceverAddressInfoDao {
    List<ReceiverAddressInfo> selectByUid(int id);

    int insert(ReceiverAddressInfo receverAddressInfo);

    int update(ReceiverAddressInfo receverAddressInfo);

    int delete(int id);
}
