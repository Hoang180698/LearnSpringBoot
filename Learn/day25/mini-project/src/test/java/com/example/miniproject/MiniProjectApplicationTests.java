package com.example.miniproject;

import com.example.miniproject.entity.Todo;
import com.example.miniproject.exception.NotFoundException;
import com.example.miniproject.repository.TodoRepository;
import com.example.miniproject.request.UpsertTodoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class MiniProjectApplicationTests {
    @Autowired
    private TodoRepository todoRepository;

    @Test
    void contextLoads() {
    }

}
