package com.foxbill.controller;

import com.foxbill.pojo.Student;
import com.foxbill.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/basicParam")
    public String basicParam(String name, int age){
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

    /**********************************日期参数获取**********************************/

    /*
        单个日期处理：

     */
    @RequestMapping("/testDate")
    public String testDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        System.out.println(date);
        return "param";
    }

    @RequestMapping("testDate2")
    public String testDate2(Student student){
        System.out.println(student);
        return "param";
    }

    /*
            全局日期处理:
            @InitBinder注解解决类中日期问题:
            这样在类中出现的所有日期都可以进行转换了。
     */
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sf,true));
    }
    @RequestMapping("/testDate3")
    public String testDate3(Date date){
        System.out.println(date);
        return "param";
    }

    /**********************************从Web后端携带数据到Web前端**********************************/
    @RequestMapping("/showParam")
    public String showParam(String name, int age, Model model, Map map, ModelMap modelMap, HttpServletRequest request){
        System.out.println(name + ":" +age);
        model.addAttribute("modelName",name);
        map.put("mapName",name);
        modelMap.addAttribute("modelMapName",name);
        modelMap.put("modelMap-age",age);
        request.setAttribute("reqName",name);
        return "showParam";
    }

}
