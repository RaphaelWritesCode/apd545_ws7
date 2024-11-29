/**********************************************
 Workshop #7
 Course: APD545 - Fall
 Last Name: Antioquia
 First Name: Raphael
 ID: 031379126
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 Signature: Raphael Antioquia
 Date: November 28, 2024
 **********************************************/

package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // Service dependency is injected via the constructor. Best practice.
    private final StudentService studentService;

    // Constructor-based dependency injection. This is preferred for immutability and easier testing.
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Handles GET requests to fetch all students.
    @GetMapping
    public List<Student> getAllStudents() {
        // Calls the service layer to fetch all students.
        return studentService.getAllStudents();
    }

    // Handles POST requests to create a new student.
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        // Calls the service layer to save a student.
        return studentService.saveStudent(student);
    }
}
