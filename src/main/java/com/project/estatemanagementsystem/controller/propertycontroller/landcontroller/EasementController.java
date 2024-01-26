package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Easement;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.EasementService;

public class EasementController implements PropertyBuilder<Easement>{
    @Autowired
    private EasementService easementService;
    @Autowired
    private UserService userService;

    @GetMapping("/formeasement")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property easement = new Easement();
        easement.setUser(loggedInUser);

        model.addAttribute("Easement", easement);
        return "formEasement";
    }

    @PostMapping("/saveEasement")
    public String saveProperty(@ModelAttribute("Easement") Easement easement){
        easementService.saveEasement(easement);

        return "redirect:/propertyList";
    }
}
