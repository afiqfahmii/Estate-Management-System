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

import jakarta.transaction.Transactional;

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
        // user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setName(userDto.getName());
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
        // String[] name = user.getName().split(" ");
        // userDto.setFirstName(name[0]);
        // userDto.setLastName(name[1]);
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

    @Transactional
    @Override
    public void updateUser(User user){
        User updatedUser = findUserById(user.getId());

        updatedUser.setId(user.getId());
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setIDType(user.getIDType());
        updatedUser.setPhoneNum(user.getPhoneNum());
        updatedUser.setIDNum(user.getIDNum());
        updatedUser.setGender(user.getGender());
        updatedUser.setDob(user.getDob());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setPostcode(user.getPostcode());
        updatedUser.setStatecode(user.getStatecode());

        userRepository.save(updatedUser);
    }

    public void saveAdmin(User user){
        User admin = new User();

        admin.setName(user.getName());
        admin.setEmail(user.getEmail());
        admin.setPhoneNum(user.getPhoneNum());
        admin.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleAdminExist();
        }
        admin.setRoles(Arrays.asList(role));
        userRepository.save(admin);
    }

    private Role checkRoleAdminExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    public void initAdmin(){
        User admin = new User();

        admin.setName("admin");
        admin.setEmail("admin@default.com");
        admin.setPhoneNum("0333033303");
        admin.setPassword(passwordEncoder.encode("admin123"));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleAdminExist();
        }
        admin.setRoles(Arrays.asList(role));
        userRepository.save(admin);
    } 

    @Override
    public List<User> findAllPewaris(){
        List<User> pewarisList = userRepository.findByRoles(roleRepository.findByName("ROLE_PEWARIS"));

        return pewarisList;
    }

    @Override
    public List<User> findAllAdmins(){
        List<User> adminList = userRepository.findByRoles(roleRepository.findByName("ROLE_ADMIN"));

        return adminList;
    }

    @Override
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    
}
