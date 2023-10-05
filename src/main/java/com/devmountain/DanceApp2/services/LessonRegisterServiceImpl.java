package com.devmountain.DanceApp2.services;

import com.devmountain.DanceApp2.dtos.LessonRegisterDto;
import com.devmountain.DanceApp2.entities.LessonRegister;
import com.devmountain.DanceApp2.repositories.DanceLessonRepository;
import com.devmountain.DanceApp2.repositories.LessonRegisterRepository;
import com.devmountain.DanceApp2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonRegisterServiceImpl implements LessonRegisterService {
    @Autowired
    private LessonRegisterRepository lessonRegisterRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private DanceLessonRepository dancelessonRepository;

    @Override
    public List<LessonRegisterDto> getAllLessonRegister() {
        List<LessonRegister> lessonRegisterList = lessonRegisterRepository.findAll();
        return lessonRegisterList.stream().map(lessonRegister -> new LessonRegisterDto(lessonRegister)).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public void addLessonRegister(LessonRegisterDto lessonRegisterDto) {
        LessonRegister lessonRegister = new LessonRegister(lessonRegisterDto);
        lessonRegisterRepository.saveAndFlush(lessonRegister);
    }
    @Override
    @Transactional
    public void deleteLessonRegisterById(Long id) {
        Optional<LessonRegister> danceLessonOptional = lessonRegisterRepository.findById(id);
        danceLessonOptional.ifPresent(lessonRegister -> lessonRegisterRepository.delete(lessonRegister));
    }
    @Override
    @Transactional
    public void updateLessonRegister(LessonRegisterDto lessonRegisterDto) {
        Optional<LessonRegister> lessonRegisterOptional = lessonRegisterRepository.findById(lessonRegisterDto.getId());
        lessonRegisterOptional.ifPresent(lessonRegister -> {
            lessonRegister.setDate(lessonRegisterDto.getDate());
            lessonRegisterRepository.saveAndFlush(lessonRegister);
        });

    }


}
