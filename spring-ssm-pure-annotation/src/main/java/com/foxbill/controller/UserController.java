package com.foxbill.controller;

import com.foxbill.domain.User;
import com.foxbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
        return "redirect:/getUsers";
    }

    @RequestMapping("/toModifyUser/{id}")
    public String toModifyUser(@PathVariable("id") int id,Map map){
        User user = userService.findUser(id);
        map.put("user",user);
        return "modifyUser";
    }

    @RequestMapping("/modifyUser")
    public String modifyUser(User user){
        userService.modifyUser(user);
        return "redirect:/getUsers";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id){
        userService.dropUser(id);
        return "redirect:/getUsers";
    }

    @RequestMapping("/toTransfer/{id}")
    public String toTransfer(@PathVariable("id") int id,Map map){
        User user = userService.findUser(id);
        List<User> userList = userService.queryUsers();
        map.put("user",user);
        map.put("userList",userList);
        return "transfer";
    }

    @RequestMapping("/transfer")
    public String transfer(int fromId,int toId,double balance){
        System.out.println(fromId + "--->" + toId);
        System.out.println(balance);
        userService.transfer(fromId,toId,balance);
        return "redirect:/getUsers";
    }

}
