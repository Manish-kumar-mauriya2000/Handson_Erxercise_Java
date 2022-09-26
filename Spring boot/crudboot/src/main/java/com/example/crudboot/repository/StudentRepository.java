package com.example.crudboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudboot.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    
}
