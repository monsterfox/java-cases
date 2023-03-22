package com.foxbill.controller;

import com.foxbill.domain.User;
import com.foxbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "forward:getUsers";
    }

    @RequestMapping("/toModifyUser/{id}")
    public String toModifyUser(@PathVariable int id){
        User user = userService.findUser(id);
        userService.modifyUser(user);
        return "forward:getUsers";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        userService.dropUser(id);
        return "forward:getUsers";
    }


}
