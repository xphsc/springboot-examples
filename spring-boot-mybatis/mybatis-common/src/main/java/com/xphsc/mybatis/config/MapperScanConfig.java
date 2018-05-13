package com.xphsc.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
@Configuration
@MapperScan(basePackages = "com.xphsc.*.mapper",sqlSessionFactoryRef = "sqlSessionFactory")
public class MapperScanConfig {
}
