package com.qf.service.impl;

import ch.qos.logback.core.util.FileUtil;
import com.qf.constant.SystemConstant;
import com.qf.service.OssService;
import com.qf.util.AUtil;
import com.qf.util.OssSingleCore;
import com.qf.util.StringUtil;
import com.qf.vo.R;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public R upload(MultipartFile file) {
        if(!file.isEmpty()){
            //重命名、限制长度
            String fn= AUtil.rename(file.getOriginalFilename());
            try{
                String url= OssSingleCore.getInstance().upload(SystemConstant.OSS_BUCKET,fn,
                        file.getBytes());
                if(!StringUtil.checkEmpty(url)){
                    return R.ok(url);
                }
            }catch (Exception e){
                return R.error(e.getMessage());
            }
        }
        return R.error("oss上传异常");
    }
}
