package com.sph.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("main").setViewName("home");
        //registry.addViewController("/deposit").setViewName("deposit");
        //registry.addViewController("/withdraw").setViewName("withdraw");
        //registry.addViewController("/home").setViewName("balance");
    }

    //国际化
    @Bean
    public LocaleResolver localResolver()
    {
        return new MyLocalResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/index.html", "/", "/user/login", "/css/*", "/js/*", "/img/**");
    }
}
