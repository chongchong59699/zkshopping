package com.qf.config;

import com.qf.util.JedisCore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: JedisConfig
 * @Author: 刘嘉豪
 * @Date: 2020/7/15
 * @Time: 16:01
 */
@Configuration
public class JedisConfig {
    @Value("${voter.redis.host}")
    private String host;
    @Value("${voter.redis.port}")
    private int port;
    @Value("${voter.redis.pass}")
    private String pass;

    @Bean
    public JedisCore createJC(){
        return new JedisCore(host,port,pass);
    }
}
