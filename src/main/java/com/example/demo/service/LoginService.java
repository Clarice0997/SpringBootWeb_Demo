package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String register(Account account){
        // 获取密码
        String password = account.getPassword();
        // 加密密码
        password = bCryptPasswordEncoder.encode(password);
        // 重新赋值加密密码
        account.setPassword(password);

        int i = loginMapper.register(account);
        if(i!=0){
            return "注册成功";
        }else{
            return "注册失败";
        }

    }
}
