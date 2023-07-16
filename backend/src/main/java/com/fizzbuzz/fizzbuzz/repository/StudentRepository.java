package com.fizzbuzz.fizzbuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fizzbuzz.fizzbuzz.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
