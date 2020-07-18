package com.qf.controller;

import com.qf.service.OssService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@Api(tags = "文件上传")
@RestController
@RequestMapping("api/oss")
public class OssController {
    @Autowired
    private OssService service;
    @PostMapping("upload")
    public R upload(MultipartFile file) {
        return R.ok(service.upload(file));
    }
}
