package com.example.springsecurity.service;

import com.example.springsecurity.model.student.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudentById(Integer studentId);
    void updateStudent(Integer studentId, Student student);
    void registerStudent(Student student);
    void deleteStudent(Integer studentId);
}
