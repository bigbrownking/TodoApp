package com.example.todoapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "content")
    private String content;
    @Column(name = "completed")
    private boolean completed = Boolean.FALSE;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Todo() {
    }

    public Todo(long id, String content, boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
