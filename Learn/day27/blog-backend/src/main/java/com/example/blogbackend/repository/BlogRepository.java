package com.example.blogbackend.repository;

import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    void deleteAllByUser(User user);

    @Query("select b from Blog b where b.status = true order by b.publishedAt DESC ")
    List<Blog> getBlogOrOrderByPublishedAt();

    @Query("select b from Blog b where  b.status =true and b.id = ?1")
    Optional<Blog> getBlogPublishedById(Integer id);

    @Query("select b from Blog b where b.status = true and upper(b.title) like upper(concat('%', ?1, '%')) ")
    List<Blog> getBlogsByKeyword(String keyword);
}