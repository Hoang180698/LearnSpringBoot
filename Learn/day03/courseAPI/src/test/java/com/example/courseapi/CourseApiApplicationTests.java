package com.example.courseapi;

import com.example.courseapi.model.Course;
import com.example.courseapi.model.User;
import com.example.courseapi.repository.CourseRepository;
import com.example.courseapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseApiApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Test
    void show_users() {
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);
    }
    @Test
    void show_courses() {
        List<Course> courseList = courseRepository.findAll();
        courseList.forEach(System.out::println);
    }

}
