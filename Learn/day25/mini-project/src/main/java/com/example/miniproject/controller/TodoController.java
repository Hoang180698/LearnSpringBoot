package com.example.miniproject.controller;

import com.example.miniproject.entity.Todo;
import com.example.miniproject.request.UpsertTodoRequest;
import com.example.miniproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")

public class TodoController {
    @Autowired
    private TodoService todoService;
//    1. Lấy danh sách todo
//    GET http://localhost:8080/api/v1/todos
    @GetMapping("todos")
    public List<Todo> getTodos() {
        return  todoService.getTodos();
    }

    // 2 tạo todo
    @PostMapping("todos")
    public Todo createTodo(@RequestBody UpsertTodoRequest request) {
        return todoService.createTodo(request);
    }

    // 3. Cập nhật todo
    @PutMapping("todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody UpsertTodoRequest request) {
        return todoService.updateTodo(id, request);
    }

    // 4. Xóa todo
    @DeleteMapping("todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
    }
}
