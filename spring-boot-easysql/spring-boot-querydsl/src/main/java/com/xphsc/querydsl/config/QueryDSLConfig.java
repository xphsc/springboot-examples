package com.xphsc.querydsl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Provider;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
public class QueryDSLConfig {
    @Autowired
    private DataSource dataSource;


    @Bean
    public SQLQueryFactory queryFactory() {
        SQLTemplates templates = MySQLTemplates.builder().quote().build();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        configuration.setExceptionTranslator(new SpringExceptionTranslator());
        Provider<Connection> provider = new SpringConnectionProvider(dataSource);
        return new SQLQueryFactory(configuration, provider);
    }

}
