package com.xphsc.restdocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.hal.CurieProvider;
import org.springframework.hateoas.hal.DefaultCurieProvider;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@SpringBootApplication(scanBasePackages="com.xphsc")
public class RestDocApplication {
    public static void main(String[] args) {
    SpringApplication.run(RestDocApplication.class, args);
}

    @Bean
    public CurieProvider curieProvider() {
        return new DefaultCurieProvider("carapi", new UriTemplate("/documentation/{rel}.html"));
    }

}
