
package com.yan.controller;

import com.yan.entity.Student;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping({"/consumer"})
public class ConsumerController {
    @Value("${server.port}")
    private String port;
    @Value("${foo}")
    private String foo;
    @Autowired
    private RestTemplate restTemplate;

    public ConsumerController() {
    }

    @GetMapping({"/findAll"})
    public Collection<Student> findAll() {
        return (Collection)this.restTemplate.getForObject("http://provider/student/findAll", Collection.class, new Object[0]);
    }

    @GetMapping({"/findAll1"})
    public Collection<Student> findAll1() {
        return (Collection)this.restTemplate.getForObject("http://provider/student/findAll", Collection.class, new Object[0]);
    }

    @GetMapping({"/findById/{id}"})
    public Student findById(@PathVariable("id") int id) {
        return (Student)this.restTemplate.getForObject("http://provider/student/findById/{id}", Student.class, new Object[]{id});
    }

    @PostMapping({"/update"})
    public void update(@RequestBody Student student) {
        this.restTemplate.postForObject("http://provider/student/update", student, Void.class, new Object[0]);
    }

    @DeleteMapping({"/deleteById/{id}"})
    public void deleteById(@PathVariable("id") int id) {
        this.restTemplate.delete("http://provider/student/deleteById/{id}", new Object[]{id});
    }

    @GetMapping({"/findport"})
    public String findport() {
        return (String)this.restTemplate.getForObject("http://provider/student/findport", String.class, new Object[0]);
    }

    @GetMapping({"/foo"})
    public String foo() {
        return this.port + this.foo;
    }
}
