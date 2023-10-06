package com.devmountain.DanceApp2.controllers;

import com.devmountain.DanceApp2.dtos.LessonRegisterDto;
import com.devmountain.DanceApp2.services.LessonRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessonRegister")
public class LessonRegisterController {
    @Autowired
    private LessonRegisterService lessonRegisterService;
    @GetMapping("/all")
    public List<LessonRegisterDto> getAllLessonRegister()
    {
        return lessonRegisterService.getAllLessonRegister();
    }
    @PostMapping("/add")
    public void addLessonRegister(@RequestBody LessonRegisterDto lessonRegisterDto)
    {
        lessonRegisterService.addLessonRegister(lessonRegisterDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteLessonRegisterById(@PathVariable Long id)
    {
        lessonRegisterService.deleteLessonRegisterById(id);
    }
    @PutMapping("/update/{id}")
    public void updateLessonRegister( @PathVariable Long id, @RequestBody LessonRegisterDto lessonRegisterDto)
    {
        lessonRegisterService.updateLessonRegister(lessonRegisterDto, id);
    }
}
