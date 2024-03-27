package com.ra.service.impl;

import com.ra.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> findAll();
    void save(StudentEntity student);
    void edit(StudentEntity student);
    StudentEntity f(int id);
    void delete(int id);
}
