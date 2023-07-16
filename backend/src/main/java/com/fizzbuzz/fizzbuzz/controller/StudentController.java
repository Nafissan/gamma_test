package com.fizzbuzz.fizzbuzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fizzbuzz.fizzbuzz.model.Student;
import com.fizzbuzz.fizzbuzz.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getResult")
    public List<String> list() {
        return studentService.getResult();
    }

    @GetMapping("/getAll")
    public List<Student> liste() {
        return studentService.getAllStudents();
    }
}
