package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.QuitRent;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.QuitRentService;

public class QuitRentController implements PropertyBuilder<QuitRent>{
    @Autowired
    private QuitRentService quitRentService;
    @Autowired
    private UserService userService;

    @GetMapping("/formProperty?type=quitrent")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property quitRent = new QuitRent();
        quitRent.setUser(loggedInUser);

        model.addAttribute("QuitRent", quitRent);
        return "formProperty";
    }

    @PostMapping("/saveQuitRent")
    public String saveProperty(@ModelAttribute("QuitRent") QuitRent quitRent){
        quitRentService.saveQuitRent(quitRent);

        return "redirect:/propertyList";
    }
}
