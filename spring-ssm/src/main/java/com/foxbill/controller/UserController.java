package com.foxbill.controller;

import com.foxbill.domain.User;
import com.foxbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public String getUsers(Map map){
        List<User> users = userService.queryUsers();
        map.put("users",users);
        return "users";
    }


}
