package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Account;
import com.example.demo.entity.Login;
import com.example.demo.entity.Order;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 登录Service
     * @param account
     * @return
     */
    public Login login(Account account){
        // 获取当前登录用户账号
        String userAccount = account.getAccount();
        // 构建登录对象
        Login login = new Login();
        // 构建条件查询条件
        QueryWrapper<Account> queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", userAccount);
        // 判断账号是否存在
        if (loginMapper.selectOne(queryWrapper) == null) {
            System.out.println("用户不存在");
            login.setCode(413);
            return login;
        } else {
            System.out.println("用户已存在");
            // 查询用户ID
            int id = loginMapper.getAccountId(account.getAccount());
            // 持久化ID
            account.setId(id);
        }
        // 账号存在则判断该账号密码是否正确
        // 获取原密码
        String originPassword = loginMapper.getPassword(account.getAccount());
        // bcrypt判断密码是否相同
        if(bCryptPasswordEncoder.matches(account.getPassword(),originPassword)){
            login.setCode(200);
            // JWT签名
            String token = JwtUtils.generateToken(account);
            login.setToken(token);
            return login;
        }else{
            login.setCode(413);
            return login;
        }
    }

    /**
     * 注册Service
     * @param account
     * @return
     */
    public String register(Account account) {
        // 获取当前注册用户账号
        String userAccount = account.getAccount();
        // 构建条件查询条件对象
        QueryWrapper<Account> queryWrapper = new QueryWrapper();
        queryWrapper.eq("account", userAccount);
        // 判断账号是否存在
        if (loginMapper.selectOne(queryWrapper) == null) {
            System.out.println("用户不存在");
        } else {
            System.out.println("用户已存在");
            return "用户已存在";
        }

        // 获取密码
        String password = account.getPassword();
        // 加密密码
        password = bCryptPasswordEncoder.encode(password);
        // 重新赋值加密密码
        account.setPassword(password);

        int i = loginMapper.register(account);
        // 判断注册是否成功
        if (i != 0) {
            return "注册成功";
        } else {
            return "注册失败";
        }

    }
}
