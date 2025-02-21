package com.daytona.cruddemo.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    RedisConnectionFactory redisConnectionFactory() {
        return new JedisConnectionFactory();
    }
//
//    @Bean
//    public RedisCacheWriter redisCacheWriter(RedisConnectionFactory factory) {
//        return RedisCacheWriter.lockingRedisCacheWriter(factory);
//    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // Use String serializer for keys
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        // Use JSON serializer for values
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }


//    @Bean
//    public RedisCacheManager cacheManager(RedisCacheWriter redisCacheWriter) {
//        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//                .disableCachingNullValues();
//        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();
//        int index = 0;
//        for (String cache : cacheList) {
//            long ttl = Long.parseLong(cacheTtlList.get(index)); // Convert TTL to long
//            cacheConfigurations.put(cache, defaultCacheConfig.entryTtl(Duration.ofSeconds(ttl)));
//            index++;
//        }
//        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig, cacheConfigurations);
//    }


//        @Bean
//    public RedisCacheManager cacheManager(RedisCacheWriter redisCacheWriter){
//        RedisCacheConfiguration defaultCacheConfigration = RedisCacheConfiguration.defaultCacheConfig()
//                .disableCachingNullValues()
//                .entryTtl(Duration.ofSeconds(120));
//    Map<String, RedisCacheConfiguration> cacheNamesConfigurationMap = new HashMap<>();
//        cacheNamesConfigurationMap.put("employeeCache", defaultCacheConfigration.entryTtl(Duration.ofSeconds(120))); // Specific cache TTL
//        return RedisCacheManager.builder(redisCacheWriter)
//            .cacheDefaults(defaultCacheConfigration)
//                .withInitialCacheConfigurations(cacheNamesConfigurationMap)
//                .build();
//    }


//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        return RedisCacheManager.builder(redisConnectionFactory)
//                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig()
//                        .entryTtl(Duration.ofSeconds(120)))
//                .build();
//    }

}
