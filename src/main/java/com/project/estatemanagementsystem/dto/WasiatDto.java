package com.project.estatemanagementsystem.dto;

import com.project.estatemanagementsystem.entity.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WasiatDto {

    private Long id;
    private User user;

    @NotEmpty(message = "Content should not be empty")
    private String content;
}
