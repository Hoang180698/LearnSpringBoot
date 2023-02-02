package com.example.blogbackend.controller;

import com.example.blogbackend.request.UpsertBlogRequest;
import com.example.blogbackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    // Xem danh sách blog
    @GetMapping("")
    public ResponseEntity<?> getAllBlog() {
        return ResponseEntity.ok(blogService.getAllBlog());
    }

    // Tạo blog
    @PostMapping("")
    public ResponseEntity<?> createBlog(@RequestBody UpsertBlogRequest request) {
        return new ResponseEntity<>(blogService.createBlog(request), HttpStatus.CREATED); // 201
    }

    // Xem chi tiết blog
    @GetMapping("{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer id) {
        return ResponseEntity.ok(blogService.getBlogById(id)); // 200
    }

    // Cập nhật thông tin blog
    @PutMapping("{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Integer id,@RequestBody UpsertBlogRequest request) {
        return ResponseEntity.ok((blogService.updateBlog(id, request)));
    }

    // Xóa Blog
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build(); //200
    }

}
