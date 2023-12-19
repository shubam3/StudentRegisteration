package com.Crud.Mvc_demo.controller;

import com.Crud.Mvc_demo.model.Student;
import com.Crud.Mvc_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("allstudentlist",studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/add")
    public String addNewStudent(Model model){
        //Student student = new Student();
        model.addAttribute("student", new Student());
        return "addStudent";
    }


    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("updateform/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model){
         Student student = studentService.getById(id);
         model.addAttribute("student", student);
         return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") long id){
        studentService.deleteById(id);
        return "redirect:/";
    }


}
