package com.foxbill.controller;

import com.foxbill.domain.Student;
import com.foxbill.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getStudents")
    @ResponseBody
    public List<Student> getStudents(){
        return studentService.queryStudents();
    }


}
