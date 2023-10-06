package com.devmountain.DanceApp2.services;

import com.devmountain.DanceApp2.dtos.DanceLessonDto;
import com.devmountain.DanceApp2.entities.DanceLesson;
import com.devmountain.DanceApp2.repositories.DanceLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    @Transactional
    public void deleteDanceLessonById(Long danceLessonId) {
        Optional<DanceLesson> danceLessonOptional = danceLessonRepository.findById(danceLessonId);
        danceLessonOptional.ifPresent(danceLesson ->
                danceLessonRepository.delete(danceLesson));
    }

    @Override
    @Transactional
    public void updateDanceLessonById(DanceLessonDto danceLessonDto, Long lessonId) {
        Optional<DanceLesson> danceLessonOptional = danceLessonRepository.findById(lessonId);
        danceLessonOptional.ifPresent(danceLesson -> {
            danceLesson.setLessonName(danceLesson.getLessonName());
            danceLesson.setDescription(danceLesson.getDescription());
            danceLessonRepository.saveAndFlush(danceLesson);
        });
    }
}

