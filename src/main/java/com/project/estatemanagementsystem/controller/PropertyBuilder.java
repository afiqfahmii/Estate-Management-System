package com.project.estatemanagementsystem.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.entity.Property;

public interface PropertyBuilder<T extends Property> {
    @GetMapping("/form")
    String showForm(Model model);

    @PostMapping("/save")
    String saveProperty(@ModelAttribute("property") T property);
}