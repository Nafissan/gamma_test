package com.fizzbuzz.fizzbuzz.service;

import com.fizzbuzz.fizzbuzz.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public List<String> getResult();
}