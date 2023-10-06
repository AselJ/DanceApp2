package com.devmountain.DanceApp2.entities;

import com.devmountain.DanceApp2.dtos.LessonRegisterDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "LessonRegister" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne
    @JsonBackReference(value = "userLessonRegister")
    private User user;

    @ManyToOne
    @JsonBackReference(value = "danceLessonLessonRegister")
    private DanceLesson danceLesson;

    public LessonRegister(LessonRegisterDto lessonRegisterDto){

        if(lessonRegisterDto.getId() != null){
            this.id = lessonRegisterDto.getId();
        }
        if(lessonRegisterDto.getDate() != null){
            this.date =lessonRegisterDto.getDate();
        }
    }
}
