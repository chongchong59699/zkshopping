package com.qf.config;

import com.qf.interceptor.TokenInterceptor;
import com.qf.util.JedisCore;
import com.qf.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TokenInterceptorConfig implements WebMvcConfigurer {
    //此处注入JedisCore

    @Autowired
    private JedisCore jedisCore;
    //private JedisCore jedisCore= JedisUtil.getJedisCore();



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置拦截器并指定拦截路径
        //registry.addInterceptor(new TokenInterceptor(jedisCore)).addPathPatterns("/api/**");
        registry.addInterceptor(new TokenInterceptor(jedisCore)).addPathPatterns("/**");
        //registry.addInterceptor(new TokenInterceptor(jedisCore)).addPathPatterns("/**");//拦截所有
        //registry.addInterceptor(new TokenInterceptor(jedisCore)).addPathPatterns("/**").excludePathPatterns("/test");//指定不拦截
        //添加自定义拦截器
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
