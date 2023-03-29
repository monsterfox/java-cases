package com.foxbill.springbootthymeleaf.controller;

import com.foxbill.springbootthymeleaf.pojo.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {
    @RequestMapping("/demo")
    public String demo(HttpServletRequest request){
        request.setAttribute("name","李四");
        return "demo";
    }

    @GetMapping("/thy/expression")
    public String expression(Model model){
        model.addAttribute("site","www.foxbill.com");
        model.addAttribute("myUser",new SysUser(1001,"李四","f",20));
        return "01-expression";
    }

    @GetMapping("/thy/expression2")
    public String expression2(Model model){
        model.addAttribute("site","www.foxbill.com");
        model.addAttribute("myUser",new SysUser(1002,"周峰","m",30));
        return "02-expression";
    }

    @GetMapping("/thy/link")
    public String link(Model model){
        model.addAttribute("stuId",1001);
        return "03-link";
    }

    @GetMapping("/query/student")
    @ResponseBody
    public String query(Integer id){
        return "查询学生id=" + id;
    }

    @GetMapping("/find/school")
    @ResponseBody
    public String find(Integer id,String name){
        return "查询2，id="+id+",姓名="+name;
    }
}
