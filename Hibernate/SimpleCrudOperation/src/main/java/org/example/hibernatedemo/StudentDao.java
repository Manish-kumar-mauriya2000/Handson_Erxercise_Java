package org.example.hibernatedemo;

import java.util.List;

public interface StudentDao {
    void saveStudent(Student student);
    void updateStudent(long id,String name,String city);
    void getStudentId(long id);
    List<Student> getAllStudents();
    void deleteStudent(long id);
}
