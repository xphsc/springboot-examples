package com.xphsc.ehcache.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    /**
     * 放入缓存
     * @param value
     * @return
     */
    @GetMapping("/setEhcache")
    @CachePut(value = "HelloWorldCache", key = "'key1'")
    public String setEhcache(String value) {
        return value;
    }

    /**
     * 查询缓存
     * @return
     */
    @GetMapping("/getEhcache")
    @Cacheable(value = "HelloWorldCache", key = "'key1'")
    public String getEhcache() {
        return "没有从缓存中获取到value";
    }

    /**
     * 删除缓存
     * @return
     */
    @GetMapping("/delEhcache")
    @CacheEvict(value = "HelloWorldCache", key = "'key1'")
    public String delEhcache() {
        return "删除缓存";
    }

}
