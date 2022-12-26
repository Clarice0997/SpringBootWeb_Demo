package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.LoginService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/system")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public Result register(Account account){
        String message = loginService.register(account);
        return Result.ok().data("message",message);
    }
}
