package com.qf.util;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName: JedisCore
 * @Author: 刘嘉豪
 * @Date: 2020/7/15
 * @Time: 15:30
 */
@Slf4j
public class JedisCore {


    private JedisPool jedisPool;
    private String pass;


    public JedisCore(int maxTotal, int maxIdle, String host, int port, String pass) {
        //维护密码
        this.pass = pass;
        // 1、设置连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置池中最大的连接数量（可选）
        config.setMaxTotal(maxTotal);
        // 设置空闲时池中保有的最大连接数（可选）
        config.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(config, host, port);
    }

    private Jedis getJedis() {
        Jedis jedis = jedisPool.getResource();
        if (pass.length() != 0) {//如果密码长度不为0  则添加连接密码
            jedis.auth(pass);
        }
        return jedis;
    }

    //新增string   带过期时间
    public void set(String key, String value, int seconds) {
        try (Jedis jedis = getJedis()) {
            jedis.setex(key, seconds, value);
        }

    }

    //删除string
    public void del(String key) {
        try (Jedis jedis = getJedis()) {
            jedis.del(key);
        }
    }

    //查询
    public String get(String key) {
        try (Jedis jedis = getJedis()) {
            log.info(jedis.toString());
            return jedis.get(key);
        }
    }

    //检查key是否存在
    public boolean checkKey(String key) {
        try (Jedis jedis = getJedis()) {
            return jedis.exists(key);
        }

    }

    //查看key的过期时间
    public long ttl(String key) {
        try (Jedis jedis = getJedis()) {
            return jedis.ttl(key);
        }

    }

    //查看某个key的数量(支持通配符)
    public int keys(String key) {
        try (Jedis jedis = getJedis()) {
            return jedis.keys(key).size();
        }

    }

    //设置key的过期时间
    public void expire(String key, int seconds) {
        try (Jedis jedis = getJedis()) {
            jedis.expire(key, seconds);
        }
    }
}
