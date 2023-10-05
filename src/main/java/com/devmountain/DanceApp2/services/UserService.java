package com.devmountain.DanceApp2.services;

import com.devmountain.DanceApp2.dtos.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
