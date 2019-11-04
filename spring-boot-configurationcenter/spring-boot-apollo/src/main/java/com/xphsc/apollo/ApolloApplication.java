package com.xphsc.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
@EnableApolloConfig
@SpringBootApplication
public class ApolloApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ApolloApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
    }
}
