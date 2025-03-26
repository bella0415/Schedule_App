package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.ScheduleRequestDto;
import com.example.scheduleapp.dto.ScheduleResponseDto;
import com.example.scheduleapp.entity.*;
import com.example.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    @Transactional
    public void createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(
                requestDto.getTitle(),
                requestDto.getAuthor(),
                requestDto.getPassword()
        );
        TodoSchedule Schedule;
        scheduleRepository.save(TodoSchedule);
    }

    // 전체 일정 조회
    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // 특정 일정 조회
    public ScheduleResponseDto getScheduleById(Long id) {
        Optional<ScheduleResponseDto> schedule = scheduleRepository.findById(id);
        return schedule.orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다."));
    }

    // 일정 수정
    @Transactional
    public void updateSchedule(Long id, ScheduleRequestDto requestDto) {
        if (!scheduleRepository.checkPassword(id, requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        scheduleRepository.update(id, requestDto.getTitle(), requestDto.getAuthor());
    }

    // 일정 삭제
    @Transactional
    public void deleteSchedule(Long id, String password) {
        if (!scheduleRepository.checkPassword(id, password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        scheduleRepository.delete(id);
    }
}
