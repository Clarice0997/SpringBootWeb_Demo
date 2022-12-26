package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public String register(Account account){
        int i = loginMapper.register(account);
        if(i!=0){
            return "注册成功";
        }else{
            return "注册失败";
        }

    }
}
