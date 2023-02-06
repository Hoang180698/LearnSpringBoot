package com.example.blogbackend.controller;

import com.example.blogbackend.request.UpsertUserRequest;
import com.example.blogbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Xem danh sách Users
    @GetMapping("")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    // Tạo Users
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody UpsertUserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    // Xem chi tiết User
    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Cập nhật thông tin user
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UpsertUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    // Xóa user
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
