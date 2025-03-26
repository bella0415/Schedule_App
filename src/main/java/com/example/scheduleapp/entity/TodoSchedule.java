package com.example.scheduleapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class TodoSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public TodoSchedule(String title, String author, String password) {
        this.title = title;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    // 직접 만든 getter 메서드 추가!
    public String getTitle() {
        return this.title;
    }

    public void update(String title, String author) {
        this.title = title;
        this.author = author;
        this.updatedAt = LocalDateTime.now();
    }
}
