package com.example.demobean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConfigBeen {
    @Bean("student3")
    public Student creatStudent() {
        return new Student("Tran Thi C", "C@gamil.com");
    }
}
