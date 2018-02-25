package com.xphsc.elasticsearch.config;


import com.xphsc.elasticsearch.base.BaseSearchRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Created by ${huipei.x} on 2017-2-25
 * qq群593802274
 */
@Configuration
@EnableElasticsearchRepositories(
        repositoryBaseClass =BaseSearchRepositoryImpl.class,
        basePackages= { "com.eglsc.elasticsearch.repository.dao" }
)
public class ElasticsearchConfig {
}
