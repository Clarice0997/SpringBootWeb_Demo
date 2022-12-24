package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
public class FileUploadController {

    // 上传头像接口
    @PostMapping("/upload")
    public String uploadAvatar(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        // 获取图片的原始名称
        System.out.println(photo.getOriginalFilename());
        // 获取文件类型
        System.out.println(photo.getContentType());

        // 动态获取服务器位置
        // HttpServletRequest request 获取前端请求对象
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo, path);
        return "上传成功";
    }

    // 保存文件函数
    public void saveFile(MultipartFile photo, String path) throws IOException {
        // 判断存储的目录是否存在，如果不存在则创建
        File dir = new File(path);
        // 判断目录是否已被创建
        if (!dir.exists()) {
        // 创建目录
            dir.mkdir();
        }
        // 构建文件对象
        File file = new File(path + photo.getOriginalFilename());
        // 写入图片
        photo.transferTo(file);
    }
}
