package com.xphsc.alimq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, ThymeleafAutoConfiguration.class})
public class AlimqApplication {
    public static void main(String[] args) {
    SpringApplication.run(AlimqApplication.class, args);
}


}
