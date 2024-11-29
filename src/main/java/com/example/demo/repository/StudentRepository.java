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

package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
