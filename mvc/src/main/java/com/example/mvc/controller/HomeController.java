package com.example.mvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mvc.model.Student;
import com.example.mvc.services.StudentService;

@Controller
public class HomeController {
    private final StudentService studentService;

    @Autowired
    public HomeController(StudentService _studentService) {
        this.studentService = _studentService;
    }

    @ModelAttribute("students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @RequestMapping({"/admin/add-student"})
    public String AddStudent() {
        return "admin/add-student";
    }

    @PostMapping("/admin/student")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/home"; // Redirect to home after adding a student
    }
}
