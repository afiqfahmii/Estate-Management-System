package com.project.estatemanagementsystem.controller.propertycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.UnitTrust;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.UnitTrustService;

public class UnitTrustController implements PropertyBuilder<UnitTrust>{
    @Autowired
    private UnitTrustService unitTrustService;
    @Autowired
    private UserService userService;

    @GetMapping("/formProperty?type=unittrust")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property unitTrust = new UnitTrust();
        unitTrust.setUser(loggedInUser);

        model.addAttribute("UnitTrust", unitTrust);
        return "formProperty";
    }

    @PostMapping("/saveUnitTrust")
    public String saveProperty(@ModelAttribute("UnitTrust") UnitTrust unitTrust){
        unitTrustService.saveUnitTrust(unitTrust);

        return "redirect:/propertyList";
    }
}
