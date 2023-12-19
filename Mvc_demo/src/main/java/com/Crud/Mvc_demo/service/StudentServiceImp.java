package com.Crud.Mvc_demo.service;

import com.Crud.Mvc_demo.model.Student;
import com.Crud.Mvc_demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        if(Objects.nonNull(student)){
            studentRepository.save(student);
        }
    }

    @Override
    public Student getById(Long id) {
        Student student = null;
        if(Objects.nonNull(id)){
            Optional<Student> optionalStudent =
            studentRepository.findById(id);
            if(optionalStudent.isPresent()){
                student = optionalStudent.get();
            }else {
                throw new RuntimeException("Student not found with id "+ id);
            }
        }
        return student;
    }

    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)){
            studentRepository.deleteById(id);
        }

    }
}
