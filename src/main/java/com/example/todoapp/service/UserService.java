package com.example.todoapp.service;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.UserRepository;
import com.example.todoapp.request.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }
    public User addUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(()->new NoSuchElementException());
        userRepository.delete(user);
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
}
