package com.project.estatemanagementsystem.controller.propertycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Insurance;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.InsuranceService;

public class InsuranceController implements PropertyBuilder<Insurance>{
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private UserService userService;

    @GetMapping("/forminsurance")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property insurance = new Insurance();
        insurance.setUser(loggedInUser);

        model.addAttribute("Insurance", insurance);
        return "formInsurance";
    }

    @PostMapping("/saveInsurance")
    public String saveProperty(@ModelAttribute("Insurance") Insurance insurance){
        insuranceService.saveInsurance(insurance);

        return "redirect:/propertyList";
    }
}
