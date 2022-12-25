package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    // 注入Mapper
    @Autowired
    private UserMapper userMapper;

    // GET请求 查询所有用户信息
    @ApiOperation(value = "查询所有用户")
    @GetMapping(value = "/user")
    public List getUsers() {
        // 获取用户列表保存为当前函数列表
        List<Users> list = userMapper.selectAllUsers();
        System.out.println(list);
        return list;
    }

    // GET请求 根据ID查询用户信息
    @ApiOperation(value = "查询指定用户")
    @GetMapping(value = "/user/{id}")
    public Users getUserById(@PathVariable int id) {
        Users user = userMapper.selectUserById(id);
        System.out.println("用户ID：" + id);
        System.out.println(user);
        return user;
    }

    // POST请求 添加用户
    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/user")
    public String saveUser(Users user) {
        // 插入用户 返回值 插入成功条数
        int i = userMapper.insertUser(user);
        if (i > 0) {
            return "添加用户成功";
        } else {
            return "添加用户失败";
        }
    }

    // PUT请求 更新用户
    @ApiOperation(value = "更新用户")
    @PutMapping(value = "/user")
    public String updateUser(Users user) {
        // 更新用户 返回值 更新成功条数
        int i = userMapper.updateUser(user);
        if (i > 0) {
            return "更新用户成功";
        } else {
            return "更新用户失败";
        }
    }

    // DELETE请求 删除用户
    @ApiOperation(value = "删除用户")
    @DeleteMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable int id) {
        System.out.println("删除用户：" + id);
        // 更新用户 返回值 更新成功条数
        int i = userMapper.deleteUser(id);
        if (i > 0) {
            return "删除用户成功";
        } else {
            return "删除用户失败";
        }
    }
}
