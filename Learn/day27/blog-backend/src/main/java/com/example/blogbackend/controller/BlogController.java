package com.example.blogbackend.controller;

import com.example.blogbackend.request.UpsertBlogRequest;
import com.example.blogbackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class BlogController {
    @Autowired
    private BlogService blogService;

    // Xem danh sách blog
    @GetMapping("admin/blogs")
    public ResponseEntity<?> getAllBlog() {
        return ResponseEntity.ok(blogService.getAllBlog());
    }

    // Tạo blog
    @PostMapping("admin/blogs")
    public ResponseEntity<?> createBlog(@RequestBody UpsertBlogRequest request) {
        return new ResponseEntity<>(blogService.createBlog(request), HttpStatus.CREATED); // 201
    }

    // Xem chi tiết blog
    @GetMapping("admin/blogs/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer id) {
        return ResponseEntity.ok(blogService.getBlogById(id)); // 200
    }

    // Cập nhật thông tin blog
    @PutMapping("admin/blogs/{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Integer id,@RequestBody UpsertBlogRequest request) {
        return ResponseEntity.ok((blogService.updateBlog(id, request)));
    }

    // Xóa Blog
    @DeleteMapping("admin/blogs/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build(); //200
    }

    //Lấy danh sách tất cả bài viết đã public theo thời gian public giảm dần
    //GET : /api/blogs (Trả về List<Blog>
    @GetMapping("blogs")
    public ResponseEntity<?> getBlogsPublishedOrderByPushedAt() {
        return ResponseEntity.ok(blogService.getBlogsPublishedOrderByPushedAt());
    }

    // Lấy chi tiết bài viết theo id (đã public)
    // GET : /api/blogs/{id} (Trả về Blog)
    @GetMapping("blogs/{id}")
    public ResponseEntity<?> getBlogPublishedById(@PathVariable Integer id) {
        return ResponseEntity.ok(blogService.getBlogPublishedById(id)) ;
    }

    // Tìm kiếm bài viết theo từ khóa
    //GET : /api/blogs/search?keyword={} (Trả về List<Blog> nếu chứa từ khóa trong title)
    @GetMapping("blogs/search")
    public ResponseEntity<?> getBlogsByKeyword(@RequestParam String keyword) {
        return ResponseEntity.ok(blogService.getBlogsByKeyword(keyword)) ;
    }

}
