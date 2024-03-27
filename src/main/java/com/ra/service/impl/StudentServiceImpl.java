package com.ra.service.impl;

import com.ra.entity.StudentEntity;
import com.ra.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class StudentServiceImpl implements  StudentService{
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(StudentEntity student) {
        studentRepository.save(student);
    }

    @Override
    public void edit(StudentEntity student) {
        studentRepository.save(student);
    }

    @Override
    public StudentEntity f(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }


}
