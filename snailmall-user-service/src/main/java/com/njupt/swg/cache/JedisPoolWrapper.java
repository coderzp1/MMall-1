package com.njupt.swg.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * @Author swg.
 * @Date 2019/1/1 15:00
 * @CONTACT 317758022@qq.com
 * @DESC
 */
@Component
@Slf4j
public class JedisPoolWrapper {
    @Autowired
    private Parameters parameters;

    private JedisPool jedisPool = null;

    @PostConstruct
    public void init(){
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(parameters.getRedisMaxTotal());
            config.setMaxIdle(parameters.getRedisMaxIdle());
            config.setMaxWaitMillis(parameters.getRedisMaxWaitMillis());
            jedisPool = new JedisPool(config,parameters.getRedisHost(),parameters.getRedisPort(),2000);
            log.info("【初始化redis连接池成功】");
        }catch (Exception e){
            log.error("【初始化redis连接池失败】",e);
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }
}
