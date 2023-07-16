package com.fizzbuzz.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fizzbuzz.fizzbuzz.model.Student;
import com.fizzbuzz.fizzbuzz.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void setStudentRepository(StudentRepository student) {
        this.studentRepository = student;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<String> getResult() {
        List<String> liste = new ArrayList<>();
        for (Student student : getAllStudents()) {
            if (student.getNombre() % 3 == 0 && String.valueOf(student.getNombre()).contains("5")
                    && student.getNombre() % 5 == 0 && String.valueOf(student.getNombre()).contains("3")) {
                liste.add("FizzBuzzFizzBuzz");
            } else if (String.valueOf(student.getNombre()).contains("3") && student.getNombre() % 5 == 0
                    && student.getNombre() % 3 == 0) {
                liste.add("FizzFizzBuzz");
            } else if (student.getNombre() % 3 == 0 && String.valueOf(student.getNombre()).contains("5")
                    && student.getNombre() % 5 == 0) {
                liste.add("BuzzFizzBuzz");
            } else if (String.valueOf(student.getNombre()).contains("3") && student.getNombre() % 3 == 0) {
                liste.add("FizzFizz");
            } else if (String.valueOf(student.getNombre()).contains("5") && student.getNombre() % 3 == 0) {
                liste.add("BuzzFizz");
            } else if (String.valueOf(student.getNombre()).contains("3") && student.getNombre() % 5 == 0
                    || student.getNombre() % 5 == 0 && student.getNombre() % 3 == 0) {
                liste.add("FizzBuzz");
            } else if (String.valueOf(student.getNombre()).contains("5") && student.getNombre() % 5 == 0) {
                liste.add("BuzzBuzz");
            } else if (student.getNombre() % 3 == 0) {
                liste.add("Fizz");
            } else if (student.getNombre() % 5 == 0) {
                liste.add("Buzz");
            } else {
                liste.add(String.valueOf(student.getNombre()));
            }
        }
        return liste;
    }
}