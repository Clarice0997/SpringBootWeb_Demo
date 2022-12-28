package com.example.demo.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.demo.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Authorization");
        if(StringUtils.isEmpty(token)){
            return false;
        }
        try {
            JwtUtils.verify(token);
        } catch (SignatureVerificationException e) {
            return false;
        } catch (TokenExpiredException e) {
            return false;
        } catch (AlgorithmMismatchException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
