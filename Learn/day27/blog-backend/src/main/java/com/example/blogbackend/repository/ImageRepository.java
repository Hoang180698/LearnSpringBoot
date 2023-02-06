package com.example.blogbackend.repository;

import com.example.blogbackend.entity.Image;
import com.example.blogbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("select i from Image i where i.user.id = ?1 order by i.createAt DESC")
    List<Image> findByUser_IdOrderByCreateAtDesc(Integer id);

    void deleteAllByUser(User user);
}