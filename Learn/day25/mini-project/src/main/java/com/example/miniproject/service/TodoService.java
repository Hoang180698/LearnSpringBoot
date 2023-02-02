package com.example.miniproject.service;

import com.example.miniproject.exception.BadRequestException;
import com.example.miniproject.exception.NotFoundException;
import com.example.miniproject.entity.Todo;
import com.example.miniproject.repository.TodoRepository;
import com.example.miniproject.request.UpsertTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public TodoService() {

    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo createTodo(UpsertTodoRequest request) {
        if (request.getTitle().trim().length() == 0) {
            throw new BadRequestException("Tieu de khong duoc de trong");
        }
        Todo todo = new Todo();
        todo.setStatus(false);
        todo.setTitle(request.getTitle());
        return todoRepository.save(todo);
    }
    public Todo updateTodo(int id, UpsertTodoRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
//        Todo todo = todos.stream().filter((user) -> {
//            return user.getId() == id;
//        }).findFirst().orElseThrow(() -> {
//            throw new NotFoundException("Not found user with id = " + id);
//        });
//        if (request.getTitle().trim().length() == 0) {
//            throw new BadRequestException("Tieu de khong duoc de trong");
//        }
        if (request.getTitle() != null) {
            todo.setTitle(request.getTitle());
        }
        todo.setStatus(request.isStatus());
        return todoRepository.save(todo);
    }
    public void deleteTodo(int id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        todoRepository.delete(todo);
    }
}
