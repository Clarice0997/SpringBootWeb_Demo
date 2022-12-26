package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Order;
import com.example.demo.entity.Users;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    // 注入Mapper
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    // GET请求 查询所有用户信息
    @ApiOperation(value = "查询所有用户和其对应订单")
    @GetMapping(value = "/allUsersAndOrders")
    public List getAllUsersAndOrders() {
        // 获取用户列表保存为当前函数列表
        List<Users> list = userMapper.selectAllUsersAndOrders();
        System.out.println(list);
        return list;
    }

    // GET请求 根据ID查询订单(Mybatis条件查询)
//    @ApiOperation(value = "根据ID查询订单")
//    @GetMapping(value = "/order/{id}")
//    public List<Order> getOrderById(@PathVariable int id) {
//        System.out.println(id);
//        return orderMapper.selectOrdersById(id);
//    }

    // GET请求 根据ID查询订单(MybatisPlus条件查询)
    @ApiOperation(value = "根据ID查询订单")
    @GetMapping(value = "/order/{id}")
    public List<Order> getOrderById(@PathVariable int id) {
        System.out.println(id);
        QueryWrapper<Order> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);
        return orderMapper.selectList(queryWrapper);
    }

    // GET请求 分页查询所有订单(Mybatis分页查询)
//    @ApiOperation(value = "分页查询所有订单")
//    @GetMapping(value = "/order")
//    public List<Order> getOrderPaging(int pageCount,int PageSize) {
//        return orderMapper.selectOrdersPaging(pageCount-1,PageSize);
//    }

    // GET请求 分页查询所有订单(MybatisPlus分页查询)
    @ApiOperation(value = "分页查询所有订单")
    @GetMapping(value = "/order")
    public IPage getOrderPaging(int pageCount,int PageSize) {
        Page<Order> page = new Page<>(pageCount,PageSize);
        IPage iPage = orderMapper.selectPage(page,null);
        return iPage;
    }
}
