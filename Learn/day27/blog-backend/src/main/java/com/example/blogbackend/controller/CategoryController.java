package com.example.blogbackend.controller;

import com.example.blogbackend.entity.Category;
import com.example.blogbackend.request.CategoryRequest;
import com.example.blogbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Xem danh sách category
    @GetMapping("admin/categories")
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    //Tạo category mới
    @PostMapping("admin/categories")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest request) {
        return new ResponseEntity<>(categoryService.createCategory(request), HttpStatus.CREATED);
    }

    //Xem chi tiết category
    @GetMapping("admin/categories/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    //Cập nhật category
    @PutMapping("admin/categories/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    //Xóa category
    @DeleteMapping("admin/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    //Lấy danh sách category bao gồm các thông tin sau
    //GET : /api/categories
    //[
    //    {
    //        id :
    //        name :
    //        used : (Số bài viết sử dụng category này)
    //    },
    //    ...
    //]

    @GetMapping("categories")
    public ResponseEntity<?> getAllCategoryAndAmountUsed() {
        return ResponseEntity.ok(categoryService.getAllCategoryAndAmountUsed());
    }
}
