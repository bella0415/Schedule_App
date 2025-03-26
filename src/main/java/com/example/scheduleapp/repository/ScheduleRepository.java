package com.example.scheduleapp.repository;

import com.example.scheduleapp.entity.TodoSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.scheduleapp.dto.ScheduleResponseDto;


import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    // 일정 저장
    public void save(TodoSchedule schedule) {
        String sql = "INSERT INTO schedule (title, author, password, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                schedule.getTitle(),
                schedule.getAuthor(),
                schedule.getPassword(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt());

    }

    // 일정 전체 조회
    public List<ScheduleResponseDto> findAll() {
        String sql = "SELECT id, title, author, created_at, updated_at FROM schedule ORDER BY updated_at DESC";
        return jdbcTemplate.query(sql, scheduleRowMapper());
    }

    // 단일 일정 조회
    public Optional<ScheduleResponseDto> findById(Long id) {
        String sql = "SELECT id, title, author, created_at, updated_at FROM schedule WHERE id = ?";
        List<ScheduleResponseDto> list = jdbcTemplate.query(sql, scheduleRowMapper(), id);
        return list.stream().findFirst();
    }

    // RowMapper
    private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
        return (rs, rowNum) -> new ScheduleResponseDto(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getTimestamp("updated_at").toLocalDateTime()
        );
    }
}
