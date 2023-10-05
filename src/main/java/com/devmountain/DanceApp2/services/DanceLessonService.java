package com.devmountain.DanceApp2.services;

import com.devmountain.DanceApp2.dtos.DanceLessonDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DanceLessonService {
    @Transactional
    List<DanceLessonDto> getAllDanceLesson();

    void addDanceLesson(DanceLessonDto danceLessonDto);

    void deleteDanceLessonById(Long danceLessonId);

    void updateDanceLesson(DanceLessonDto lessonDanceDto);
}
