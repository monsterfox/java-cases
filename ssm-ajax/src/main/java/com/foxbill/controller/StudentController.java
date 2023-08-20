package com.foxbill.controller;

import com.foxbill.domain.Student;
import com.foxbill.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


    /*设置首页*/
    @RequestMapping("/")
    public String toList(){
        return "redirect:static/list-axios.html";
    }

    @RequestMapping("/findAll")
    @ResponseBody  //返回json
    public Object findAllStudents(){
        List<Student> list = studentService.findAllStudents();
        return list;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public void doAdd(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @RequestMapping("/toUpt")
    @ResponseBody
    public Object toUpt(int id){
        Student student = studentService.findStudentById(id);
        return student;
    }

    @RequestMapping("/doUpt")
    @ResponseBody
    public void doUpt(@RequestBody Student student){
        studentService.modifyStudent(student);
    }

    @RequestMapping("/doDel")
    @ResponseBody
    public void doDel(int id){
        studentService.removeStudent(id);
    }

}
