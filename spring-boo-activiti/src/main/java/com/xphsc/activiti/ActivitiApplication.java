package com.xphsc.activiti;

import org.activiti.spring.boot.DataSourceProcessEngineAutoConfiguration;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@SpringBootApplication(scanBasePackages="com.xphsc",exclude = {DataSourceProcessEngineAutoConfiguration.class})
public class ActivitiApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ActivitiApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
    }

}
