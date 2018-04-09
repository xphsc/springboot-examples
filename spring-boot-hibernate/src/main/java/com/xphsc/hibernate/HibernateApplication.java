package com.xphsc.hibernate;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by ${huipei.x} on 2017-2-25
 * qq群593802274
 */
@SpringBootApplication(scanBasePackages="com.xphsc",exclude = {JpaRepositoriesAutoConfiguration.class})
public class HibernateApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(HibernateApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
    }
}
