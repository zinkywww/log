package com.wzy.log_system.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class RedisConfiguration {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        log.info("开始创建Redis模板对象");
        RedisTemplate template = new RedisTemplate();
        //设置连接工厂
        template.setConnectionFactory(factory);
        //设置序列化器
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }
}
