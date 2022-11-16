package com.example.btvn2login.controller;

import com.example.btvn2login.dto.UserDto;
import com.example.btvn2login.request.UpsertUserRequest;
import com.example.btvn2login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //POST http://localhost:8080/login
    @PostMapping("login")
    public UserDto login(@Valid @RequestBody UpsertUserRequest request) {
        return userService.login(request);
    }
}
