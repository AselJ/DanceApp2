package com.devmountain.DanceApp2.dtos;

import com.devmountain.DanceApp2.entities.LessonRegister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonRegisterDto implements Serializable {
    private Long id;
    private LocalDate date;


    public LessonRegisterDto(LessonRegister lessonRegister){

        if(lessonRegister.getId() != null){
            this.id = lessonRegister.getId();
        }
        if(lessonRegister.getDate() != null){
            this.date =lessonRegister.getDate();
        }
    }

}
