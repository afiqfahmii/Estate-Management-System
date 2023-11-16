package com.project.estatemanagementsystem.service;

import java.util.List;

import com.project.estatemanagementsystem.dto.UserDto;
import com.project.estatemanagementsystem.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
