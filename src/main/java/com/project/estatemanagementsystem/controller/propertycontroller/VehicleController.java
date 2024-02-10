package com.project.estatemanagementsystem.controller.propertycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Vehicle;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.VehicleService;

public class VehicleController implements PropertyBuilder<Vehicle>{
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private UserService userService;

    @GetMapping("/formProperty?type=vehicle")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property vehicle = new Vehicle();
        vehicle.setUser(loggedInUser);

        model.addAttribute("Vehicle", vehicle);
        return "formProperty";
    }

    @PostMapping("/saveVehicle")
    public String saveProperty(@ModelAttribute("Vehicle") Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);

        return "redirect:/propertyList";
    }
}
