package com.xphsc.log4j2;


import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by ${huipei.x} on 2017-2-25
 * qq群593802274
 */
@SpringBootApplication(scanBasePackages="com.xphsc")
public class Log4j2Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Log4j2Application.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);

    }


}
