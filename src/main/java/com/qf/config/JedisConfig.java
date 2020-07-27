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

    @Bean
    public JedisCore createJC() {
        // 1、设置连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置池中最大的连接数量（可选）
        config.setMaxTotal(50);
        // 设置空闲时池中保有的最大连接数（可选）
        config.setMaxIdle(10);
        return new JedisCore(config,host, port, pass);
    }
}
