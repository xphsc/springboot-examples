package com.xphsc.mybatis;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by ${huipei.x} on 2017-2-25
 * qq群593802274
 */
@SpringBootApplication(scanBasePackages="com.xphsc")
public class MybatisDynaminSqlApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(MybatisDynaminSqlApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
    }
}
