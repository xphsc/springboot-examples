package com.xphsc.jersey.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.SpringComponentProvider;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ${huipei.x} on 2017-2-25
 * qq群593802274
 */
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(RequestContextFilter.class);
        packages("com.xphsc");
        register(JacksonFeature.class);
        register(RequestContextFilter.class);
        register(LoggingFilter.class);
        register(SpringComponentProvider.class);
    }

}
