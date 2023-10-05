package com.devmountain.DanceApp2.repositories;

import com.devmountain.DanceApp2.entities.DanceLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DanceLessonRepository extends JpaRepository<DanceLesson, Long> {

    Optional<DanceLesson> findById(Long lessonId);
}
