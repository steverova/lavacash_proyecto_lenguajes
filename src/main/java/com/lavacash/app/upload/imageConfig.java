package com.lavacash.app.upload;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class imageConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String path = "/imagenes/**";
        String route = "file:/C:/recursos/imagenes/";
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler(path).addResourceLocations(route);

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/public", "classpath:/static/")
                .setCachePeriod(31556926);

    }



}
