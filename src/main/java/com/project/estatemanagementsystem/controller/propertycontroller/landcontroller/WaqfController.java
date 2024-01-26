package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Waqf;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.WaqfService;

public class WaqfController implements PropertyBuilder<Waqf>{
    @Autowired
    private WaqfService waqfService;
    @Autowired
    private UserService userService;

    @GetMapping("/formwaqf")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property waqf = new Waqf();
        waqf.setUser(loggedInUser);

        model.addAttribute("Waqf", waqf);
        return "formWaqf";
    }

    @PostMapping("/saveWaqf")
    public String saveProperty(@ModelAttribute("Waqf") Waqf waqf){
        waqfService.saveWaqf(waqf);

        return "redirect:/propertyList";
    }
}
