package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Maintenance;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.MaintenanceService;

public class MaintenanceController implements PropertyBuilder<Maintenance>{
    @Autowired
    private MaintenanceService maintenanceService;
    @Autowired
    private UserService userService;

    @GetMapping("/formProperty?type=maintenance")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property maintenance = new Maintenance();
        maintenance.setUser(loggedInUser);

        model.addAttribute("Maintenance", maintenance);
        return "formProperty";
    }

    @PostMapping("/saveMaintenance")
    public String saveProperty(@ModelAttribute("Maintenance") Maintenance maintenance){
        maintenanceService.saveMaintenance(maintenance);

        return "redirect:/propertyList";
    }
}
