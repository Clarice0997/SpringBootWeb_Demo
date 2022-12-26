package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    // 注入Mapper
    @Autowired
    private UserMapper userMapper;

    // GET请求 查询所有用户信息
    @ApiOperation(value = "查询所有用户和其对应订单")
    @GetMapping(value = "/allUsersAndOrders")
    public List getAllUsersAndOrders() {
        // 获取用户列表保存为当前函数列表
        List<Users> list = userMapper.selectAllUsersAndOrders();
        System.out.println(list);
        return list;
    }
}
