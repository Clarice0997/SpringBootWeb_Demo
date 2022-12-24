package com.example.demo.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.User;

@RestController
public class ParamsController {

    // 普通GET请求
    @RequestMapping(value = "/getTest1", method = RequestMethod.GET)
    public String getTest1() {
        return "GET请求";
    }

    // GET带参数
    @RequestMapping(value = "/getTest2", method = RequestMethod.GET)
    public String getTest2(String nickname, String phone) {
        System.out.println("nickname:" + nickname);
        System.out.println("phone:" + phone);
        return "GET请求";
    }

    // GET带参数 非必须
    // 参数映射
    // RequestParam默认required参数为True 如果非必须参数需手动配置
    @RequestMapping(value = "/getTest3", method = RequestMethod.GET)
    public String getTest3(@RequestParam(value = "nickname", required = false) String name) {
        System.out.println("nickname:" + name);
        return "GET请求";
    }

    // GET带参数 非必须 默认值
    // defaultValue参数
    @RequestMapping(value = "/getTest4", method = RequestMethod.GET)
    public String getTest4(@RequestParam(value = "nickname", required = false, defaultValue = "陌生人") String name) {
        System.out.println("nickname:" + name);
        return "GET请求";
    }

    // 普通POST请求
    @RequestMapping(value = "/postTest1", method = RequestMethod.POST)
    public String postTest1() {
        return "POST请求";
    }

    // POST请求带参
    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public String postTest2(String username, String password) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return "POST请求";
    }

    // Post请求 结果封装到实体类中
    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public String postTest3(User user) {
        System.out.println(user);
        return "POST请求";
    }

    // Post请求 @RequestBody
    @RequestMapping(value = "/postTest4", method = RequestMethod.POST)
    public String postTest4(@RequestBody User user) {
        System.out.println(user);
        return "POST请求";
    }

    // Post请求 非必须处理
    @RequestMapping(value = "/postTest5", method = RequestMethod.POST)
    public String postTest5(@RequestBody(required = false) User user) {
        if (user == null) {
            return "不存在user";
        }
        return "POST请求";
    }

    // 通配符请求
    @GetMapping("/test/*")
    public String test() {
        return "通配符请求";
    }
}
