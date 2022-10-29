package com.yan.service;

import com.yan.entity.Student;

import java.util.Collection;

public interface StudentService {
    public Collection<Student> findAll();
    public Student findById(int id);
    public void Update(Student student);
    public void deleteById(int id);
}
