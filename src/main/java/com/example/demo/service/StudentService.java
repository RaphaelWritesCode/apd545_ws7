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

package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    // Injecting the StudentRepository dependency
    private final StudentRepository studentRepository;

    // Constructor-based dependency injection for better testability and immutability
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Fetches a student by ID.
     * @param id The ID of the student to fetch.
     * @return The student entity.
     * @throws RuntimeException If the student with the given ID is not found.
     */
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    /**
     * Fetches all students from the database.
     * @return List of all students.
     */
    public List<Student> getAllStudents() {
        // Calls the repository to retrieve all students
        return studentRepository.findAll();
    }

    /**
     * Saves a new student to the database.
     * @param student The student entity to save.
     * @return The saved student entity.
     */
    public Student saveStudent(Student student) {
        // Calls the repository to save the student entity
        return studentRepository.save(student);
    }

    /**
     * Updates an existing student's details.
     * @param id The ID of the student to update.
     * @param updatedStudent The student entity with updated details.
     * @return The updated student entity.
     * @throws RuntimeException If the student with the given ID is not found.
     */
    public Student updateStudent(Integer id, Student updatedStudent) {
        // Fetches the student by ID, wrapped in an Optional
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            // If the student exists, update the necessary fields
            Student student = optionalStudent.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            // Save and return the updated student
            return studentRepository.save(student);
        } else {
            // Throw an exception if the student is not found
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    /**
     * Deletes a student by ID.
     * @param id The ID of the student to delete.
     * @throws RuntimeException If the student with the given ID is not found.
     */
    public void deleteStudent(Integer id) {
        // Check if the student exists by ID
        if (studentRepository.existsById(id)) {
            // If the student exists, delete it
            studentRepository.deleteById(id);
        } else {
            // Throw an exception if the student is not found
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }
}
