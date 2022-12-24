package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
    // 重写
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        System.out.println("LoginInterceptor");
        return true;
    }
}
