package com.example.courseapi.controller;

import com.example.courseapi.model.Course;
import com.example.courseapi.model.CourseUser;
import com.example.courseapi.request.UpsertCourseRequest;
import com.example.courseapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CourseController {
    @Autowired
    private CourseService courseService;


    //GET /api/v1/courses?type={typeValue}name={nameValue}&topic={topicValue}
    // Xem danh sách tất cả khóa học
    @GetMapping("courses")
    public List<Course> findAllCourses(@RequestParam(required = false) String type,
                                       @RequestParam(required = false) String name,
                                       @RequestParam(required = false) String topic) {
        return courseService.findCourses(type,name,topic);
    }

    //GET /api/v1/courses/{id} : Xem thông tin của 1 khóa học cụ thể
    @GetMapping("courses/{id}")
    public CourseUser getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    //Xem danh sách khóa học (GET /api/v1/admin/courses)
    @GetMapping("admin/courses")
    public List<Course> getCourses() {
        return courseService.getAllCourse();
    }

    //Tạo khóa học mới (POST /api/v1/admin/courses)
    @PostMapping("admin/courses")
    public Course creatCourse(@Valid @RequestBody UpsertCourseRequest request) {
        return courseService.createCourse(request);
    }

    //Lấy chi tiết khóa học (GET /api/v1/admin/courses/{id})
    @GetMapping("admin/courses/{id}")
    public Course findCourseById(@PathVariable int id) {
        return courseService.findCourseById(id);
    }

    //Cập nhật thông tin khóa học (PUT /api/v1/admin/courses/{id})
    @PutMapping("admin/courses/{id}")
    public Course updateCourse(@PathVariable int id,@Valid @RequestBody UpsertCourseRequest request) {
        return courseService.updateCourse(id, request);
    }

    //Xóa khóa học (DELETE /api/v1/admin/courses/{id})
    @DeleteMapping("admin/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id); ;
    }

}
