package com.devmountain.DanceApp2.controllers;

import com.devmountain.DanceApp2.dtos.UserDto;
import com.devmountain.DanceApp2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    // Autowired in our Dependencies, which are the UserService because Controllers interact with ServiceLayers and the PasswordEncoder so that we can have incoming passwords
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //create a method that handle POST request to be able to register a USER.
    @PostMapping("/register")
    public List<String> addUser(@RequestBody UserDto userDto){
        String passHash = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(passHash);
        return userService.addUser(userDto);
    }
    //create a method that handle logging a user in.
    @PostMapping("/login")
    public List<String> userLogin(@RequestBody UserDto userDto){
        return userService.userLogin(userDto);
    }
}
