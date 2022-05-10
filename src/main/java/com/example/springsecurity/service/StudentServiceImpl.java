package com.example.springsecurity.service;

import com.example.springsecurity.model.student.Student;
import com.example.springsecurity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.getById(studentId);
    }

    @Override
    public void updateStudent(Integer studentId, Student student) {
        student.setId(studentId);

        studentRepository.save(student);
    }

    @Override
    public void registerStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
