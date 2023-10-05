package com.devmountain.DanceApp2.repositories;

import com.devmountain.DanceApp2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByUsername(String username);
}



