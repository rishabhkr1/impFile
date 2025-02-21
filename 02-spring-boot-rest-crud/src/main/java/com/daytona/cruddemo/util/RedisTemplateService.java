package com.daytona.cruddemo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisTemplateService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setValue(final String key, final String value, final Integer timeInSeconds) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, timeInSeconds, TimeUnit.SECONDS);
    }

    public void setValue(final String key, final String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void remove(final String key) {
        redisTemplate.delete(key);
    }

    public Object getValue(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Boolean setIfAbsent(String key, String value, final Integer timeInSeconds) {
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(key, value);
        redisTemplate.expire(key, timeInSeconds, TimeUnit.SECONDS);
        return aBoolean;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Boolean setIfAbsentPropagationNotSupported(String key, String value, final Integer timeInSeconds) {
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(key, value);
        redisTemplate.expire(key, timeInSeconds, TimeUnit.SECONDS);
        return aBoolean;
    }

    public Boolean setIfAbsent(String key, String value, final long timeInSeconds) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeInSeconds, TimeUnit.SECONDS);
    }

    /**
     * Set lifetime expiry redis key
     */
    public Boolean setIfAbsent(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

}

