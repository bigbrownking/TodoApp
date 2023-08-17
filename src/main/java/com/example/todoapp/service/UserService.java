package com.example.todoapp.service;

import com.example.todoapp.entity.User;
import com.example.todoapp.repository.UserRepository;
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
}
