package com.foxbill.controller;

import com.foxbill.pojo.Student;
import com.foxbill.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String toList(){
        return "redirect:findAll";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Student> findAllStudents(){
        List<Student> list = studentService.findAllStudents();
        return list;
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "addStudent";
    }

    @RequestMapping("/doAdd")
    public String doAdd(Student student){
        studentService.addStudent(student);
        return "redirect:findAll";
    }

    @RequestMapping("/toUpt")
    public String toUpt(int id,Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student",student);
        return "uptStudent";
    }

    @RequestMapping("/doUpt")
    public String doUpt(Student student){
        studentService.modifyStudent(student);
        return "redirect:findAll";
    }

    @RequestMapping("/doDel")
    public String doDel(int id){
        studentService.removeStudent(id);
        return "redirect:findAll";
    }

}
