package com.yan.service.impl;

import com.yan.entity.Student;
import com.yan.service.StudentService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private static Map<Integer,Student> studentMap;

    static {
        studentMap=new HashMap<>();
        studentMap.put(1,new Student(1,"yan1",22));
        studentMap.put(2,new Student(2,"yan2",24));
        studentMap.put(3,new Student(3,"yan3",26));
    }


    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(int id) {
        return studentMap.get(id);
    }

    @Override
    public void Update(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public void deleteById(int id) {
        studentMap.remove(id);
    }
}
