package com.xphsc.test;

import com.github.xphsc.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ${huipei.x} on 2018-5-20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {
    @Autowired
private CacheManager cacheManager;
    @Autowired
    private Cache cache1;

    @Test
    public void test() {
        // 显示所有的Cache空间
        System.out.println(StringUtil.join(cacheManager.getCacheNames(), ","));
        Cache cache = cacheManager.getCache("HelloWorldCache");
        cache.put("key1", "value1");
        System.out.println("缓存完毕");
        String value = cache.get("key1", String.class);
        System.out.println(value);
    }

    @Test
    public void test1() {
        cache1.put("key2", "value2");
        System.out.println("缓存完毕");
        String value = cache1.get("key2", String.class);
        System.out.println(value);
    }


}
