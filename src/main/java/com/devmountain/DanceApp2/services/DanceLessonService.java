package com.devmountain.DanceApp2.services;

import com.devmountain.DanceApp2.dtos.DanceLessonDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DanceLessonService {

    List<DanceLessonDto> getAllDanceLesson();
    @Transactional
    void addDanceLesson(DanceLessonDto danceLessonDto);
    @Transactional
    void deleteDanceLessonById(Long lessonId);
    @Transactional
    void updateDanceLesson(DanceLessonDto danceLessonDto, Long lessonId);
}
