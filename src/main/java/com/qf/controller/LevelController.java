package com.qf.controller;

import com.qf.service.LevelServer;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@Api(tags = "标题等级接口")
@RestController
@RequestMapping("api/levelController/")
public class LevelController {
    @Autowired
    private LevelServer server;

    @GetMapping("queryLevel")
    public R queryLevel(){

        return server.queryLevel();
    }
}
