package com.qf.test;

import com.qf.util.OssSingleCore;

public class OssTest {
    public static void main(String[] args) {
        String json ="{\"id\":101,\"msg\":\"测试数据\"}";
        String u= OssSingleCore.getInstance().upload("zkwg","str001.json",json.getBytes());
        System.out.println(u);    }
}
