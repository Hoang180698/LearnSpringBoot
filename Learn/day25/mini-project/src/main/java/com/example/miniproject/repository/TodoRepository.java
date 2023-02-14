package com.example.miniproject.repository;

import com.example.miniproject.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
    // lay tat ca danh sach
    List<Todo> findAll();

    Optional<Todo> findById(int id);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update todo u set u.title  = ?2 where u.id = ?1")
    void updateTitleById(int id, String title);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update todo u set u.status  = ?2 where u.id = ?1")
    void updateStatusById(int id, boolean status);

}
