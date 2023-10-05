package com.devmountain.DanceApp2.services;

import com.devmountain.DanceApp2.dtos.DanceLessonDto;
import com.devmountain.DanceApp2.entities.DanceLesson;
import com.devmountain.DanceApp2.repositories.DanceLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

@Service
public class DanceLessonServiceImpl implements DanceLessonService {
    @Autowired
    private DanceLessonRepository danceLessonRepository;

    @Override
    public List<DanceLessonDto> getAllDanceLesson() {
        List<DanceLesson> danceLessonList = danceLessonRepository.findAll();
        return danceLessonList.stream().map(danceLesson -> new DanceLessonDto(danceLesson)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addDanceLesson(DanceLessonDto danceLessonDto) {
        DanceLesson danceLesson = new DanceLesson(danceLessonDto);
        danceLessonRepository.saveAndFlush(danceLesson);
    }

    @Override
    public void deleteDanceLessonById(Long danceLessonId) {
        Optional<DanceLesson> danceLessonOptional = danceLessonRepository.findById(danceLessonId);
        danceLessonOptional.ifPresent(danceLesson ->
                danceLessonRepository.delete(danceLesson));
    }
    @Override
    public void updateDanceLesson(DanceLessonDto lessonDanceDto) {
        PatternSyntaxException danceLessonDto = null;
        Optional<DanceLesson> danceLessonOptional = danceLessonRepository.findById(danceLessonDto.getClass());
        danceLessonOptional.ifPresent(danceLesson -> {
            danceLesson.setLessonName(danceLessonDto.getMessage());
            danceLesson.setDescription(danceLessonDto.getDescription());
            danceLessonRepository.saveAndFlush(danceLesson);
        });

    }
}

