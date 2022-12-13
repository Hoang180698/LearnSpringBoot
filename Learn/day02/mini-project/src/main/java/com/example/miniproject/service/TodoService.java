package com.example.miniproject.service;

import com.example.miniproject.exception.NotFoundException;
import com.example.miniproject.model.Todo;
import com.example.miniproject.request.UpsertTodoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TodoService {
    private List<Todo> todos;

    public TodoService() {
        todos = new ArrayList<>();
        todos.add(new Todo(1,"Chơi game", true));
        todos.add(new Todo(2,"Học", false));
        todos.add(new Todo(3,"Đi đá bóng", true));
        todos.add(new Todo(4,"Đi chơi với bạn bè", false));
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo createTodo(UpsertTodoRequest request) {
        Random rd = new Random();
        int id = rd.nextInt(1000);

        Todo todo = new Todo(id, request.getTitle(), false);
        todos.add(todo);
        return todo;
    }
    public Todo updateTodo(int id, UpsertTodoRequest request) {
        Todo todo = todos.stream().filter((user) -> {
            return user.getId() == id;
        }).findFirst().orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        if (request.getTitle() != null) {
            todo.setTitle(request.getTitle());
        };
        todo.setStatus(request.isStatus());
        return todo;
    }
    public void deleteTodo(int id) {
        Todo todo = todos.stream().filter((user) -> {
            return user.getId() == id;
        }).findFirst().orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        todos.remove(todo);
    }
}
