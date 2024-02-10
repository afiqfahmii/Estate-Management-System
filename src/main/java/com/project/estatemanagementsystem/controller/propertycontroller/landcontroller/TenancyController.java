package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Tenancy;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.TenancyService;

public class TenancyController implements PropertyBuilder<Tenancy>{
    @Autowired
    private TenancyService tenancyService;
    @Autowired
    private UserService userService;

    @GetMapping("/formProperty?type=tenancy")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property tenancy = new Tenancy();
        tenancy.setUser(loggedInUser);

        model.addAttribute("Tenancy", tenancy);
        return "formProperty";
    }

    @PostMapping("/saveTenancy")
    public String saveProperty(@ModelAttribute("Tenancy") Tenancy tenancy){
        tenancyService.saveTenancy(tenancy);

        return "redirect:/propertyList";
    }
}
