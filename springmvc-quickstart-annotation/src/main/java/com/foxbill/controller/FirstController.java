package com.foxbill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
    @RequestMapping("/first")
    public ModelAndView doHello() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("hello","Hello My First SpringMVC!");
        mav.setViewName("main");
        return mav;
    }
}
