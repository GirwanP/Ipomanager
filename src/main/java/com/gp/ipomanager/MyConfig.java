package com.gp.ipomanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gp.ipomanager.interceptor.AuditInterceptor;

@Configuration
public class MyConfig implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getAuditInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/resources/**");
    }
    
    
    
    
    @Bean
    public AuditInterceptor getAuditInterceptor	() {
    	return new AuditInterceptor() ;
    }
}