package com.qf.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName: JedisUtil
 * @Author: 刘嘉豪
 * @Date: 2020/7/27
 * @Time: 14:42
 */
@Component
public class JedisUtil {
    private static String host = "47.92.157.246";
    private static int port = 6379;
    private static JedisPool jedisPool;
    static {

    }

    private static JedisPool getJedisPool(){
        // 1、设置连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置池中最大的连接数量（可选）
        config.setMaxTotal(50);
        // 设置空闲时池中保有的最大连接数（可选）
        config.setMaxIdle(10);
        jedisPool= new JedisPool(config, host, port);
        return  jedisPool;
    }


    public static JedisCore getJedisCore() {
        Jedis jedis = getJedisPool().getResource();
        System.out.println(jedis);
        return new JedisCore(jedis);
    }
}
