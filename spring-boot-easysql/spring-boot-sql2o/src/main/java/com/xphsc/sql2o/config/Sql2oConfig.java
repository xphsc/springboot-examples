package com.xphsc.sql2o.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

import javax.sql.DataSource;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Configuration
public class Sql2oConfig {

    @Bean
    public Sql2o sql2o(DataSource dataSource ) {
        return new Sql2o(dataSource);
    }
}
