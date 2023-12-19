package com.Crud.Mvc_demo.service;

import com.Crud.Mvc_demo.model.Student;

import java.util.List;
public interface StudentService {
    List<Student> getAllStudents();

    void save(Student student);

    Student getById(Long id);

    void deleteById(Long id);
}

