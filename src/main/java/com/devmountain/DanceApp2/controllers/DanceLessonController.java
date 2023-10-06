package com.devmountain.DanceApp2.controllers;

import com.devmountain.DanceApp2.dtos.DanceLessonDto;
import com.devmountain.DanceApp2.services.DanceLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/danceLessons")
public class DanceLessonController {
    @Autowired
    private DanceLessonService danceLessonService;
    @GetMapping("/all")
    public List<DanceLessonDto> getAllLesson() {
        return danceLessonService.getAllDanceLesson();
    }
    @PostMapping("/add")
    public void addDanceLesson(@RequestBody DanceLessonDto danceLessonDto) {
        danceLessonService.addDanceLesson(danceLessonDto);
    }
    @DeleteMapping("/delete/{lessonId}")
    public void deleteDanceLessonById(@PathVariable Long lessonId) {
        danceLessonService.deleteDanceLessonById(lessonId);
    }

    @PutMapping("/{lessonId}")
    public void updateDanceLesson(@PathVariable Long lessonId, @RequestBody DanceLessonDto danceLessonDto) {
       danceLessonService.updateDanceLessonById(danceLessonDto, lessonId);
    }
}
