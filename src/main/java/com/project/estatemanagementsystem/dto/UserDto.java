package com.project.estatemanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    private String name;
    // @NotEmpty
    // private String firstName;
    // @NotEmpty
    // private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;

    private String IDType;

    @Size(max = 12, message = "ID number cannot exceed 12 characters")
    private String IDNum;

    private String gender;

    private String dob;

    private String address;
    
    @Size(min = 5, max = 5, message = "Postcode must be exactly 5 characters")
    private String postcode;

    private String statecode;
}
