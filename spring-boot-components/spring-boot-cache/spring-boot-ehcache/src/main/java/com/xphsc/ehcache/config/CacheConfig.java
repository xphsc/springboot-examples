package com.xphsc.ehcache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public Cache getCache(@Autowired CacheManager cacheManager) {
        return cacheManager.getCache("HelloWorldCache");
    }
}
