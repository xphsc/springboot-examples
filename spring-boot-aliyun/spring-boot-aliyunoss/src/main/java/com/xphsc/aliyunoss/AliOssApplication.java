package com.xphsc.aliyunoss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@SpringBootApplication(scanBasePackages={"com.xphsc"})
public class AliOssApplication {
    public static void main(String[] args) {
        SpringApplication.run(AliOssApplication.class, args);
    }
}
