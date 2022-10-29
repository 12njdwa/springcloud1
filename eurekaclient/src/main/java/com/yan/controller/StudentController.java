package com.yan.controller;

import com.yan.entity.Student;
import com.yan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") int id){
        return studentService.findById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody Student student){
        studentService.Update(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        studentService.deleteById(id);
    }

    @GetMapping("/findport")
    public String findport(){
        return "端口号是"+this.port;
    }



}
