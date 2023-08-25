package com.foxbill.controller;

import com.foxbill.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class AjaxController {

/*    @RequestMapping("/testajax")
    @ResponseBody
    public String testAjax(){
        return "Hello Ajax";
    }*/

    @RequestMapping("/testajax")
    public void testAjax(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("Hello Ajax!");
    }


    @RequestMapping("/check")
    public void check(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user.getUsername());
        PrintWriter out = response.getWriter();

        if ("admin".equals(user.getUsername())){
            out.println("0");
        }else{
            out.println("1");
        }
    }

    @RequestMapping("/reciveJson")
    @ResponseBody
    public Object reciveJson(@RequestBody User user) throws IOException {
        System.out.println(user.getUsername());
        System.out.println(user.getSex());

        return user;
    }


}
