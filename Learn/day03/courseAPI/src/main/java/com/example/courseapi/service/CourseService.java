package com.example.courseapi.service;

import com.example.courseapi.exception.NotFoundException;
import com.example.courseapi.model.Course;
import com.example.courseapi.model.CourseUser;
import com.example.courseapi.model.User;
import com.example.courseapi.repository.CourseRepository;
import com.example.courseapi.repository.UserRepository;
import com.example.courseapi.request.UpsertCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Course> findCourses(String type, String name, String topic) {
        List<Course> listType = courseRepository.findCoursesByType(type);
        List<Course> listName = courseRepository.findCoursesByName(name);
        List<Course> listTopic = courseRepository.findCoursesByTopic(topic);

        List<Course> list = new ArrayList<>(courseRepository.findAll());
        list.retainAll(listName);
        list.retainAll(listTopic);
        list.retainAll(listType);

        return list;
    }
    public CourseUser getCourseById(int id) {
        Course course = courseRepository.getCourseById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found course with id = " + id);
        });
        User user = userRepository.findById(course.getUserId()).orElseThrow(() -> {
            throw new NotFoundException("Khoa hoc nay chua co nguoi quan ly");
        });
        return new CourseUser(course,user);
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Course findCourseById(int id) {
        return courseRepository.getCourseById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found course with id = " + id);
        });
    }

    public Course createCourse(UpsertCourseRequest request) {
        if (!userRepository.findById(request.getUserId()).isPresent()) {
            throw new NotFoundException("Not found User with userId");
        }
        Random rd = new Random();
        int id = rd.nextInt(1000);

        Course course = new Course(id, request.getName(),
                request.getDescription(),
                request.getType(),
                request.getTopics(),
                request.getThumbnail(), request.getUserId());
        courseRepository.save(course);
        return course;
    }
    public Course updateCourse(int id, UpsertCourseRequest request) {
        Course course = courseRepository.getCourseById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found Course with id = " + id);
        });
        if (!userRepository.findById(request.getUserId()).isPresent()) {
            throw new NotFoundException("Not found User with userId");
        }
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setType(request.getType());
        course.setTopics(request.getTopics());
        course.setThumbnail(request.getThumbnail());
        course.setUserId(request.getUserId());
        return course;
    }
    public void deleteCourse(int id) {
        Course course = courseRepository.getCourseById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found course with id = " + id);
        });
        courseRepository.delete(course);
    }
}
