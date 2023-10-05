package com.devmountain.DanceApp2.repositories;

import com.devmountain.DanceApp2.entities.LessonRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRegisterRepository extends JpaRepository<LessonRegister, Long> {

}
