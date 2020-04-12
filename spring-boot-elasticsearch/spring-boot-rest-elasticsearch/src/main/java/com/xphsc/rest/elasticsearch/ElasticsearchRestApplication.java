package com.xphsc.rest.elasticsearch;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * qq群593802274
 * @description:
 * @date:
 * @since 0.1.0
 */
@SpringBootApplication(scanBasePackages="com.xphsc")
public class ElasticsearchRestApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(ElasticsearchRestApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
    }
}
