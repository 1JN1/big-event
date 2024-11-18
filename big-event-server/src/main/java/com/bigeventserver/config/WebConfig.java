package com.bigeventserver.config;

import com.bigeventserver.interceptors.LoginInterceptor;
import com.bigeventserver.properties.CorsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description
 **/

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private CorsProperties corsProperties;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/api/user/login", "/api/user/register", "/doc.html")
                .addPathPatterns("/api/**");
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {


        String[] allowedHeaders = corsProperties.getAllowedHeaders();
        String[] allowedOrigins = corsProperties.getAllowedOrigins();
        String[] allowedMethods = corsProperties.getAllowedMethods();

        CorsRegistration registration = registry.addMapping("/**");

        if (allowedHeaders != null && allowedHeaders.length > 0) {
            registration.allowedHeaders(allowedHeaders);
        }

        if (allowedOrigins != null && allowedOrigins.length > 0) {
            registration.allowedOrigins(allowedOrigins);
        }

        if (allowedMethods != null && allowedMethods.length > 0) {
            registration.allowedMethods(allowedMethods);
        }

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
}
