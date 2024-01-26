package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Mortgage;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.MortgageService;

public class MortgageController implements PropertyBuilder<Mortgage>{
    @Autowired
    private MortgageService mortgageService;
    @Autowired
    private UserService userService;

    @GetMapping("/formmortgage")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property mortgage = new Mortgage();
        mortgage.setUser(loggedInUser);

        model.addAttribute("Mortgage", mortgage);
        return "formMortgage";
    }

    @PostMapping("/saveMortgage")
    public String saveProperty(@ModelAttribute("Mortgage") Mortgage mortgage){
        mortgageService.saveMortgage(mortgage);

        return "redirect:/propertyList";
    }
}
