package com.fizzbuzz.fizzbuzz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.fizzbuzz.fizzbuzz.model.Student;
import com.fizzbuzz.fizzbuzz.repository.StudentRepository;

public class StudentServiceTest {
    @Test
    public void testGetAllStudents() {
        // Créer un mock du StudentRepository
        StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
        Student stud = new Student();
        Student stud2 = new Student();
        stud.setId((long) 1);
        stud.setNombre(1);
        stud2.setId((long) 2);
        stud2.setNombre(2);
        // Définir le comportement attendu du mock
        List<Student> expectedStudents = Arrays.asList(
                stud,
                stud2);
        when(studentRepository.findAll()).thenReturn(expectedStudents);

        // Instancier le StudentService avec le mock du repository
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentRepository(studentRepository);

        // Appeler la méthode à tester
        List<Student> actualStudents = studentService.getAllStudents();

        // Vérifier le résultat
        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testGetResult() {
        StudentServiceImpl studentService = Mockito.mock(StudentServiceImpl.class);
        List<String> expectedStringList = Arrays.asList("BuzzFizz", "Fizz", "FIzzFizz");
        when(studentService.getResult()).thenReturn(expectedStringList);
        List<String> actualStringList = studentService.getResult();

        assertEquals(expectedStringList, actualStringList);

    }
}
