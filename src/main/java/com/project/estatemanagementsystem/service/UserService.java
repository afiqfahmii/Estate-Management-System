package com.project.estatemanagementsystem.service;

import java.util.List;

import com.project.estatemanagementsystem.dto.UserDto;
import com.project.estatemanagementsystem.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    void saveAdmin(User user);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
    
    //?-----------------------------------------------------
    User getCurrentUser();

    //?edit
    User findUserById(Long userId);

    void updateUser(User user);

    void initAdmin();

    List<User> findAllPewaris();

    List<User> findAllAdmins();

    void deleteUserById(Long id);
    
}
