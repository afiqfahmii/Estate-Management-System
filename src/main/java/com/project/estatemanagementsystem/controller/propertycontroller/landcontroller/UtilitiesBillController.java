package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.UtilitiesBill;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.UtilitiesBillService;

public class UtilitiesBillController implements PropertyBuilder<UtilitiesBill>{
    @Autowired
    private UtilitiesBillService utilitiesBillService;
    @Autowired
    private UserService userService;

    @GetMapping("/formutilitiesbill")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property utilitiesBill = new UtilitiesBill();
        utilitiesBill.setUser(loggedInUser);

        model.addAttribute("UtilitiesBill", utilitiesBill);
        return "formUtilitiesBill";
    }

    @PostMapping("/saveUtilitiesBill")
    public String saveProperty(@ModelAttribute("UtilitiesBill") UtilitiesBill utilitiesBill){
        utilitiesBillService.saveUtilitiesBill(utilitiesBill);

        return "redirect:/propertyList";
    }
}
