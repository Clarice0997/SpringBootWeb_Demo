# Spring Boot Web Demo

# 初学 Spring Boot Web 项目

[配套笔记](https://sapphire-christmas-a88.notion.site/SpringBoot-daa9e12fbc9a490687c4c6a60a946b01)

## Spring Boot 介绍

> Spring Boot是一个用于快速构建企业级应用程序的框架。它使用了 Spring Framework，为应用程序提供了一组完整的工具集，包括依赖注入、事务管理、Web 开发支持、以及更多。 Spring Boot 还提供了自动配置功能，使得开发人员可以快速启动并运行一个新的 Spring 应用程序。只需编写简单的配置文件，就可以让 Spring Boot 自动检测并使用合适的默认设置。这使得开发人员可以更快地开发应用程序，而无需关心复杂的底层配置。

## 涉及知识点

- [x] Spring Boot项目构建
- [x] 控制器Controller应用
- [x] 静态资源访问
- [x] 文件上传功能
- [x] 拦截器定义与注册
- [x] RESTful接口设计
- [x] Swagger接口文档配置与生成
- [x] Mybatis Plus应用
  - [x] 增删改查
  - [x] 多表查询
  - [x] 条件查询
  - [x] 分页查询
- [x] JWT验证
- [x] bcrypt密码加密

## 文件结构

```
├── config                          // Spring Boot配置文件夹
│   ├── IntercaptorConfig.java        // 登录拦截器配置
│   ├── MyBatisPlusConfig.java        // Mybatis Plus分页功能配置
│   ├── SecurityConfig.java           // bcrypt配置
│   ├── SwaggerConfig.java            // Swagger配置
│   └── WebConfig.java                // 拦截器配置
├── controller                      // 控制器层文件夹
│   ├── DemoController.java           // 1.Demo控制器
│   ├── ParamsController.java         // 2.GET POST测试控制器
│   ├── UserController.java           // 3.RESTful风格控制器
│   ├── FileUploadController.java     // 4.文件上传控制器
│   ├── OrderController.java          // 5.多表查询 条件查询 分页查询控制器
│   └── LoginController.java          // 6.登录注册控制器
├── entity                          // 实体类文件夹
│   ├── Account.java                  // 账号实体类
│   ├── Login.java                    // 登录实体类
│   ├── Order.java                    // 订单实体类
│   ├── User.java                     // 用户实体类
│   └── Users.java                    // 用户实体类
├── interceptor                     // 拦截器文件夹
│   ├── JWTInterceptor.java           // JWT拦截器（校验JWT是否合法）
│   └── LoginInterceptor.java         // 登录拦截器
├── mapper                          // 数据持久层文件夹
│   ├── LoginMapper.java              // 登录Mapper
│   ├── OrderMapper.java              // 订单Mapper
│   └── UserMapper.java               // 用户Mapper
├── service                         // 业务逻辑层文件夹
│   └── LoginService.java             // 登录业务逻辑（登录注册）
├── utils                           // 工具类文件夹
│   ├── JwtUtils.java                 // JWT校验工具类
│   ├── Result.java                   // 网络请求返回结果类
│   ├── ResultCode.java               // 网络请求状态码
│   └── UserRequest.java              // 网络请求获取Token类
├── DemoApplication.java            // Spring Boot 启动类
└── application.properties          // Spring Boot 配置文件
```
