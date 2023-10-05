package com.devmountain.DanceApp2.dtos;

import com.devmountain.DanceApp2.entities.DanceLesson;
import com.devmountain.DanceApp2.entities.LessonRegister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanceLessonDto implements Serializable {
    private Long lessonId;
    private String lessonName;
    private String description;
    private Set<LessonRegister> registrationSet = new HashSet<>();

    public DanceLessonDto(DanceLesson danceLesson)
    {
        if(danceLesson.getLessonId() != null){
            this.lessonId = danceLesson.getLessonId();
        }
        if(danceLesson.getLessonName() != null){
            this.lessonName = danceLesson.getLessonName();
        }
        if(danceLesson.getDescription() != null){
            this.description = danceLesson.getDescription();
        }
    }

}
