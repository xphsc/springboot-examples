package com.xphsc.resteasy.config;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by ${huipei.x} on 2017-2-25
 * qqȺ593802274
 */
@ConditionalOnWebApplication
@Component
@Provider
@ServerInterceptor
public class ResteasyServletContext implements ContainerRequestFilter {

    @Inject
    ServletContext sc;
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        ResteasyProviderFactory.getContextDataMap().put(ServletContext.class, sc);
    }
}
