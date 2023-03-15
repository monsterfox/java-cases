package com.foxbill.controller;

import com.foxbill.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @RequestMapping("/basicParam")
    public String basicParam(String name,int age){
        System.out.println(name + ":" +age);
        return "param";
    }

    @RequestMapping("/objectParam")
    public String objectParam(User user){
        System.out.println(user);
        return "param";
    }

    @RequestMapping("/pathParam/{name}/{age}")
    public String pathParam(@PathVariable String name,@PathVariable int age){
        System.out.println(name + ":" + age);
        return "param";
    }


    @RequestMapping("/reqParam")
    public String reqParam(@RequestParam("myname") String name){
        System.out.println(name);
        return "param";
    }

    @RequestMapping("/servletParam")
    public String servletParam(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println(name);
        return "param";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody String json){
        System.out.println(json);
        return "param";
    }
}
