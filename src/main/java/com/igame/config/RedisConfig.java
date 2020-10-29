package com.igame.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igame.entity.GameImages;
import com.igame.entity.GameInfo;
import com.igame.entity.wrapper.GameInfoWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-23 11:02
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, GameInfoWrapper> gameRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, GameInfoWrapper> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 值采用json序列化
        template.setValueSerializer(RedisSerializer.json());
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(RedisSerializer.json());

        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(RedisSerializer.string());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<String, GameImages> picRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, GameImages> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 值采用json序列化
        template.setValueSerializer(RedisSerializer.json());
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(RedisSerializer.json());
        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(RedisSerializer.string());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<String, GameInfo> infoRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, GameInfo> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 值采用json序列化
        template.setValueSerializer(RedisSerializer.json());
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(RedisSerializer.json());
        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(RedisSerializer.string());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 值采用json序列化
        template.setValueSerializer(RedisSerializer.json());
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(RedisSerializer.json());
        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(RedisSerializer.string());
        template.afterPropertiesSet();
        return template;
    }

//    @Primary
    @Bean
    public RedisCacheManager gameCacheManager(
            RedisConnectionFactory redisConnectionFactory) {
        //默认1
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string()))
                .disableCachingNullValues();
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(config)
                .transactionAware()
                .build();
        return redisCacheManager;
    }


}
