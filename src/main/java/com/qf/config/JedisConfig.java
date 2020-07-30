package com.qf.config;

import com.qf.util.JedisCore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName: JedisConfig
 * @Author: 刘嘉豪
 * @Date: 2020/7/15
 * @Time: 16:01
 */
@Configuration
public class JedisConfig {
    @Value("${zkwg.redis.host}")
    private String host;
    @Value("${zkwg.redis.port}")
    private int port;
    @Value("${zkwg.redis.pass}")
    private String pass;
    @Value("${zkwg.redis.maxTotal}")
    private int maxTotal;
    @Value("${zkwg.redis.maxIdle}")
    private int maxIdle;

    @Bean
    public JedisCore createJC() {

        return new JedisCore(maxTotal,maxIdle,host, port, pass);
    }
}
