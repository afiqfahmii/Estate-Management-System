package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Charge;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.ChargeService;

public class ChargeController implements PropertyBuilder<Charge>{
    @Autowired
    private ChargeService chargeService;
    @Autowired
    private UserService userService;

    // @GetMapping("/formcharge")
    // public String showForm(@RequestParam("type") String propertyType, Model model){
    //     User loggedInUser = userService.getCurrentUser();

    //     Property charge = new Charge();
    //     charge.setUser(loggedInUser);

    //     model.addAttribute("Charge", charge);
    //     return "formCharge";
    // }

    @GetMapping("/formProperty?type=charge")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property charge = new Charge();
        charge.setUser(loggedInUser);

        model.addAttribute("Charge", charge);
        return "formProperty";
    }

    @PostMapping("/saveCharge")
    public String saveProperty(@ModelAttribute("Charge") Charge charge){
        chargeService.saveCharge(charge);

        return "redirect:/propertyList";
    }
}
