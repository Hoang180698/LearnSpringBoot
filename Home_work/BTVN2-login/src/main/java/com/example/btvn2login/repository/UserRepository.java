package com.example.btvn2login.repository;

import com.example.btvn2login.database.UserDatabase;
import com.example.btvn2login.model.User;
import com.example.btvn2login.request.UpsertUserRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    public Optional<User> login(UpsertUserRequest request) {
        return UserDatabase.users.stream()
                .filter(user -> user.getUsername().equals(request.getUsername()) && user.getPassword().equals(request.getPassword()))
                .findFirst();
    }
}
