package com.example.blogbackend.repository;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.Comment;
import com.example.blogbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    void deleteAllByBlog(Blog blog);
    void deleteAllByUser(User user);
}