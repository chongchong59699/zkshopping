package com.qf.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName: JedisCore
 * @Author: 刘嘉豪
 * @Date: 2020/7/15
 * @Time: 15:30
 */
public class JedisCore {
    private Jedis jedis;

    public JedisCore(String host,int port,String pass) {
        JedisPool jedisPool = new JedisPool(host,port);
        jedis=jedisPool.getResource();
        if(pass.length()!=0){//如果密码长度不为0  则添加连接密码
            jedis.auth(pass);
        }


    }

    //新增string   带过期时间
    public void set(String key,String value,int seconds){
        jedis.setex(key, seconds, value);
    }
    //删除string
    public void del(String key){
        jedis.del(key);
    }
    //查询
    public String get(String key){
        return jedis.get(key);
    }
    //检查key是否存在
    public boolean checkKey(String key){
        return jedis.exists(key);
    }
    //查看key的过期时间
    public long ttl(String key){
        return jedis.ttl(key);
    }
    //查看某个key的数量(支持通配符)
    public int keys(String key){
        return jedis.keys(key).size();
    }
    //设置key的过期时间
    public void expire(String key,int seconds){
        jedis.expire(key,seconds);
    }
}
