package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Lease;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.LeaseService;

public class LeaseController implements PropertyBuilder<Lease>{
    @Autowired
    private LeaseService leaseService;
    @Autowired
    private UserService userService;

    @GetMapping("/formlease")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property lease = new Lease();
        lease.setUser(loggedInUser);

        model.addAttribute("Lease", lease);
        return "formLease";
    }

    @PostMapping("/saveLease")
    public String saveProperty(@ModelAttribute("Lease") Lease lease){
        leaseService.saveLease(lease);

        return "redirect:/propertyList";
    }
}
