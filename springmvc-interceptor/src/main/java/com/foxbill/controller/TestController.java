package com.foxbill.controller;

import com.foxbill.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {
    //通过请求转发跳到WEB-INF目录下的资源上
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
    //验证登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, HttpSession session){
        if ("admin".equals(user.getUsername()) && "123".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "main";
        }
        session.setAttribute("msg","用户名或密码不正确！");
        return "login";
    }
    //访问主页
    @RequestMapping("/main")
    public String toMain(){
        return "main";
    }
    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

}
