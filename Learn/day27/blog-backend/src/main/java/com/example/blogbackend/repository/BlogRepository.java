package com.example.blogbackend.repository;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    void deleteAllByUser(User user);
}