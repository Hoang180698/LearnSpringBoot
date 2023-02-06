package com.example.blogbackend.controller;

import com.example.blogbackend.request.CategoryRequest;
import com.example.blogbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Xem danh sách category
    @GetMapping("")
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    //Tạo category mới
    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest request) {
        return new ResponseEntity<>(categoryService.createCategory(request), HttpStatus.CREATED);
    }

    //Xem chi tiết category
    @GetMapping("{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    //Cập nhật category
    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    //Xóa category
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
