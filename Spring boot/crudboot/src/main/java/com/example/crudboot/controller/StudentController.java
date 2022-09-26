package com.example.crudboot.controller;

import com.example.crudboot.model.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudboot.model.Student;
import com.example.crudboot.services.StudentServices;

@RestController
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @Autowired
    private ModelMapper modelMapper;

    public StudentDto convertToDto(Student student) {
        return modelMapper.map(student, StudentDto.class);

    }
    public Student convertToStudent(StudentDto studentDto){
        return modelMapper.map(studentDto, Student.class);
    }

    @PostMapping("/student/save")
    public StudentDto saveStudent(@RequestBody StudentDto data) {
        Student student=convertToStudent(data);
        Student createStudent= studentServices.saveStudent(student);
        return convertToDto(createStudent);

    }

    @PutMapping("/student/edit")
    public StudentDto editStudent(@RequestBody StudentDto data) {
        Student student=convertToStudent(data);
        Student editStudent = studentServices.editStudent(student);
        return convertToDto(editStudent);
    }

    @GetMapping("/student/{id}")
    public Student searchById(@PathVariable("id") Long id){
        return studentServices.searchById(id);
    }

    @PostMapping("/student/delete")
    public Boolean deleteStudent(@RequestBody StudentDto data){
        Student student=convertToStudent(data);
        return studentServices.deleteStudent(student);
    }

    
    
}
