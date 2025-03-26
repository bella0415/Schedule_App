package com.example.scheduleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}