package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 应用该配置
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    // 注册拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/user/**") 指定拦截路径 不配置则默认拦截所有请求
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**");
    }
}
