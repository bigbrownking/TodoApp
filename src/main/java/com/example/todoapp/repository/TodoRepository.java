package com.example.todoapp.repository;

import com.example.todoapp.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
