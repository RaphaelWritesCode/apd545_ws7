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

package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    // Marks this field as the primary key of the entity.
    // The @GeneratedValue annotation with GenerationType.IDENTITY ensures that the ID
    // will be auto-incremented by the database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // The @Column annotation with nullable = false enforces non-null values for 'name'
    // at the database level.
    @Column(nullable = false)
    private String name;

    // Enforces non-null values for 'age' at the database level.
    @Column(nullable = false)
    private Integer age;

    // Enforces uniqueness for the 'email' column at the database level.
    @Column(unique = true)
    private String email;


    // Getters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    // Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
