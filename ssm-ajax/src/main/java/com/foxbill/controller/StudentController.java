package com.foxbill.controller;

import com.foxbill.domain.Student;
import com.foxbill.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "redirect:static/list.html";
    }

    @RequestMapping("/findAll")
    @ResponseBody  //返回json
    public Object findAllStudents(){
        List<Student> list = studentService.findAllStudents();

        return list;
    }

    @RequestMapping("/doAdd")
    public String doAdd(Student student){
        studentService.addStudent(student);
        return "redirect:static/list.html";
    }

    @RequestMapping("/toUpt")
    @ResponseBody
    public Object toUpt(int id,Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student",student);
        return student;
    }

    @RequestMapping("/doUpt")
    public String doUpt(Student student){
        studentService.modifyStudent(student);
        return "redirect:static/list.html";
    }

    @RequestMapping("/doDel")
    public String doDel(int id){
        studentService.removeStudent(id);
        return "redirect:static/list.html";
    }

}
