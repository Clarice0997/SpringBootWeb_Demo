package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/system")
public class LoginController {
    @Autowired
    private LoginService loginService;

    // 注册接口
    @PostMapping("/register")
    public Result register(Account account){
        String message = loginService.register(account);
        if(message == "注册成功"){
            return Result.ok().data("message",message);
        }else{
            return Result.error().data("message",message);
        }
    }

    // 登录接口
    @PostMapping("/login")
    public Result login(Account account){
        Login login = loginService.login(account);
        if(login.getCode() == 200){
            return Result.ok().data("token",login.getToken());
        }else{
            return Result.error().data("message","登录失败");
        }
    }

    // 获取用户信息接口
    @GetMapping("/userInfo")
    public Result userInfo(){
        return Result.error().data("message","获取个人信息失败");
    }
}
