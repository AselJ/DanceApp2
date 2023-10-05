package com.devmountain.DanceApp2.entities;

import com.devmountain.DanceApp2.dtos.DanceLessonDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DanceLessons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanceLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long lessonId;

    @Column
    private String lessonName;

    @Column
    private String description;

    @OneToMany(mappedBy = "danceLesson", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<LessonRegister> registrationSet = new HashSet<>();
    public DanceLesson(DanceLessonDto danceLessonDto)
    {
        if(danceLessonDto.getLessonId() != null){
            this.lessonId = danceLessonDto.getLessonId();
        }
        if(danceLessonDto.getLessonName() != null){
            this.lessonName = danceLessonDto.getLessonName();
        }
        if(danceLessonDto.getDescription() != null){
            this.description = danceLessonDto.getDescription();
        }
    }

}
