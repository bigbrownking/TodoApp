package com.example.todoapp.controller;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.repository.UserRepository;
import com.example.todoapp.request.AddTodoRequest;
import com.example.todoapp.request.AddUserRequest;
import com.example.todoapp.service.TodoService;
import com.example.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final TodoService todoService;
    @Autowired
    public UserController(UserService userService, TodoService todoService) {
        this.userService = userService;
        this.todoService = todoService;
    }

    @GetMapping("/{user_id}")
    public User getUserById(@PathVariable Long user_id){
        return userService.findUserById(user_id);
    }
    @PostMapping("/")
    public User addUser(@RequestBody AddUserRequest userRequest){
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        return userService.addUser(user);
    }

    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest){
        User user = userService.findUserById(userId);
        Todo todo = new Todo();
        todo.setContent(todoRequest.getContent());
        user.getTodoList().add(todo);
        todoService.saveTodo(todo);
        userService.saveUser(user);
    }
    @PostMapping("/todos/{todoId}")
    public void toggleTodoCompleted(@PathVariable Long todoId){
        Todo todo = todoService.findTodoById(todoId);
        todo.setCompleted(!todo.isCompleted());
        todoService.saveTodo(todo);

    }
    @DeleteMapping("/{userId}/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId, @PathVariable Long userId){
        User user = userService.findUserById(userId);
        Todo todo = todoService.findTodoById(todoId);
        user.getTodoList().remove(todo);
        todoService.deleteTodo(todoId);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
