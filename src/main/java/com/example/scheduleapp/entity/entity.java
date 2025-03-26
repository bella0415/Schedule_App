package com.example.scheduleapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
class ScheduleApp {
    private Long id;
    private String title;
    private String author;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScheduleApp(String title, String author, String password) {
        this.title = title;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(String title, String author) {
        this.title = title;
        this.author = author;
        this.updatedAt = LocalDateTime.now();
    }
}
