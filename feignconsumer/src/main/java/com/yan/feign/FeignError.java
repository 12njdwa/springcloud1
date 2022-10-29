package com.yan.feign;

import com.yan.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeignProviderClient{

    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String findport() {
        return "服务器维护中";
    }
}
