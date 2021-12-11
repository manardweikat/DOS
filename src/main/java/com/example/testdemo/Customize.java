package com.example.testdemo;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public abstract class Customize  implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

    public void customize(ConcurrentMapCacheManager cacheManager){
        cacheManager.setCacheNames(Collections.singleton("catalog"));
    }


}
