package com.foxbill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String upload(String username, MultipartFile picFile){
        System.out.println("普通项：" + username);
        System.out.println("文件项：" + picFile);
        System.out.println("文件名：" + picFile.getOriginalFilename());
        //保存到一个指定的磁盘目录
        try {
            picFile.transferTo(new File("d:\\"+picFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }
}
