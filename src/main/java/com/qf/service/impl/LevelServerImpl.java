package com.qf.service.impl;

import com.qf.dao.LevelDao;
import com.qf.service.LevelServer;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelServerImpl implements LevelServer {

    @Autowired
    private LevelDao dao;
    @Override
    public R queryLevel() {
        return R.ok(dao.queryLevel());
    }
}
