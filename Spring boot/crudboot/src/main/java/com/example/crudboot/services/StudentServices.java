package com.example.crudboot.services;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudboot.model.Student;
import com.example.crudboot.repository.StudentRepository;

@Service
public class StudentServices {
    Logger logger = Logger.getLogger(StudentServices.class.getName());
    @Autowired
    private StudentRepository studentRepository;


    public Student saveStudent(Student data) {
        return  studentRepository.save(data);
    }

    public Student searchById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    public Student editStudent(Student data) {
        Student student = studentRepository.getReferenceById(data.getId());
        student.setFirstName(data.getFirstName());
        student.setLastName(data.getLastName());
        student.setEmail(data.getEmail());
        student.setCity(data.getCity());
        student = studentRepository.save(student);
        return student;

    }

    public void getStudent(Long id) {

        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentRepository.delete(student);
            }
        }
    }

    public Boolean deleteStudent(Student data) {
        try {
            Student student = studentRepository.getReferenceById(data.getId());
            if (student.getId() == data.getId()) {
                getStudent(data.getId());
                return true;
            }
        } catch (Exception e) {
            logger.warning("Something wrong");
        }
        return false;
    }


}