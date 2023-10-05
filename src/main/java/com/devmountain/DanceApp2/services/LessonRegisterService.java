package com.devmountain.DanceApp2.services;

import com.devmountain.DanceApp2.dtos.LessonRegisterDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LessonRegisterService {
    List<LessonRegisterDto> getAllLessonRegister();

    @Transactional
    void addLessonRegister(LessonRegisterDto lessonRegisterDto);

    @Transactional
    void deleteLessonRegisterById(Long id);

    @Transactional
    void updateLessonRegister(LessonRegisterDto lessonRegisterDto);
}
