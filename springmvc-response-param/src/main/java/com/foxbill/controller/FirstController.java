package com.foxbill.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foxbill.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstController {
    @RequestMapping("/modelAndView")
    public ModelAndView getmodelAndView(String name,String pwd){
        System.out.println(name + pwd);
        ModelAndView mav = new ModelAndView();
        mav.addObject("name",name);
        mav.setViewName("show");
        return mav;
    }

    @RequestMapping("/string")
    public String getstring(String name, String pwd, Model model){
        System.out.println(name + pwd);
        //除了使用方法中的Model参数，也可以使用方法中的HttpServletRequest对象和方法中的HttpSession对象
        model.addAttribute("name",name);
        return "show";
    }

    @RequestMapping("/returnVoid")
    public void getreturnVoid(User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        //把对象转json  -- fastjson
        /*String jsonUser = JSON.toJSONString(user);
        System.out.println("fastjson转换的："+jsonUser);*/
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUser = objectMapper.writeValueAsString(user);
        System.out.println("jackson转换的："+jsonUser);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.write(jsonUser);
        out.close();

    }

    //只有当请求路径和ajax请求类型都对上时，目标方法才会被调用
    @RequestMapping("/list")
    @ResponseBody
    public List<User> ajaxRequest(){
        //User类含有属性:name(String), age(int)，无参和全参构造方法，全属性的getter,setter,toString方法
        List<User> users = new ArrayList<>();
        User u1 = new User("荷包蛋", 20);
        User u2 = new User("饺子", 21);
        User u3 = new User("橘子", 22);
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;//SpringMVC框架会自动将对象数组转化为json数据格式返回给前端ajax请求
     }


}
