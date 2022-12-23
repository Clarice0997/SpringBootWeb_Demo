package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 声明控制类
@RestController
public class DemoController {
    // GetMapping注释 需要带明确的请求地址
    // http://localhost:8080/demo
    // Get请求Mapping Post请求Mapping
    // @GetMapping("/demo") @PostMapping("/demo")
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String Demo(){
        return "你好 世界";
    }
}