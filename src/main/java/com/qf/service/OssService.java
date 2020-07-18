package com.qf.service;

import com.qf.vo.R;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    R upload(MultipartFile file);
}
