package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Caveat;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.CaveatService;

public class CaveatController implements PropertyBuilder<Caveat>{
    @Autowired
    private CaveatService caveatService;
    @Autowired
    private UserService userService;

    @GetMapping("/formcaveat")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property caveat = new Caveat();
        caveat.setUser(loggedInUser);

        model.addAttribute("Caveat", caveat);
        return "formCaveat";
    }

    @PostMapping("/saveCaveat")
    public String saveProperty(@ModelAttribute("Caveat") Caveat caveat){
        caveatService.saveCaveat(caveat);

        return "redirect:/propertyList";
    }
}
