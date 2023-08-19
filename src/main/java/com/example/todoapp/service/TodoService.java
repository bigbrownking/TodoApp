package com.example.todoapp.service;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TodoService{
    private final TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public Todo findTodoById(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }
    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
    }
    public void deleteTodo(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        todoRepository.delete(todo);
    }
}
