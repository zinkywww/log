package com.wzy.log_system;


import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SpringBootRedisTests {
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test() {
        System.out.println(redisTemplate);
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //set get setnx setex setnx
        ops.set("key1", "value1");
        ops.set("code","1234",3, TimeUnit.MINUTES);
        ops.setIfAbsent("key2", "value2");
        ops.setIfAbsent("key2", "value3");

    }
}
