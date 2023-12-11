package com.project.estatemanagementsystem.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.estatemanagementsystem.dto.UserDto;
import com.project.estatemanagementsystem.entity.Role;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.repository.RoleRepository;
import com.project.estatemanagementsystem.repository.UserRepository;
import com.project.estatemanagementsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setIDNum(userDto.getIDNum());
        user.setIDType(userDto.getIDType());
        user.setGender(userDto.getGender());
        user.setDob(userDto.getDob());
        user.setAddress(userDto.getAddress());
        user.setPostcode(userDto.getPostcode());
        user.setStatecode(userDto.getStatecode());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_PEWARIS");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        userDto.setIDNum(user.getIDNum());
        userDto.setIDType(user.getIDType());
        userDto.setGender(user.getGender()); 
        userDto.setDob(user.getDob());
        userDto.setAddress(user.getAddress());
        userDto.setPostcode(user.getPostcode());
        userDto.setStatecode(user.getStatecode());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_PEWARIS");
        return roleRepository.save(role);
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return findByEmail(authentication.getName());
        }
        // Handle the case where no user is authenticated (return null or throw an exception)
        return null;
    }

//?newly added
    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    
}
