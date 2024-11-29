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

package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Start the Spring Boot application context
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		// Get the StudentService bean
		StudentService studentService = context.getBean(StudentService.class);

		// 1. Add new students
		Student student1 = new Student();
		student1.setName("Alice Johnson");
		student1.setAge(20);
		student1.setEmail("alice.johnson@example.com");
		Student savedStudent1 = studentService.saveStudent(student1);
		System.out.println("Added Student: " + savedStudent1);

		Student student2 = new Student();
		student2.setName("Bob Smith");
		student2.setAge(22);
		student2.setEmail("bob.smith@example.com");
		Student savedStudent2 = studentService.saveStudent(student2);
		System.out.println("Added Student: " + savedStudent2);

		// 2. Retrieve and print all students
		System.out.println("All Students: " + studentService.getAllStudents());

		// 3. Update a student
		Student updatedStudent = new Student();
		updatedStudent.setName("Alice Updated");
		updatedStudent.setAge(21);
		updatedStudent.setEmail("alice.updated@example.com");
		Student updatedResult = studentService.updateStudent(savedStudent1.getId(), updatedStudent);
		System.out.println("Updated Student: " + updatedResult);

		// 4. Delete a student
		studentService.deleteStudent(savedStudent2.getId());
		System.out.println("Deleted Student with ID: " + savedStudent2.getId());

		// 5. Print all students after deletion
		System.out.println("All Students after Deletion: " + studentService.getAllStudents());
	}
}
