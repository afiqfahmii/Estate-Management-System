package com.project.estatemanagementsystem.controller.propertycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Debenture;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.DebentureService;

public class DebentureController implements PropertyBuilder<Debenture>{
    @Autowired
    private DebentureService debentureService;
    @Autowired
    private UserService userService;

    @GetMapping("/formProperty?type=debenture")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property debenture = new Debenture();
        debenture.setUser(loggedInUser);

        model.addAttribute("Debenture", debenture);
        return "formProperty";
    }

    @PostMapping("/saveDebenture")
    public String saveProperty(@ModelAttribute("Debenture") Debenture debenture){
        debentureService.saveDebenture(debenture);

        return "redirect:/propertyList";
    }
}
