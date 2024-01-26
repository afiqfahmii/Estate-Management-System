package com.project.estatemanagementsystem.controller.propertycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Bond;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.BondService;

public class BondController implements PropertyBuilder<Bond>{
    @Autowired
    private BondService bondService;
    @Autowired
    private UserService userService;

    @GetMapping("/formbond")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property bond = new Bond();
        bond.setUser(loggedInUser);

        model.addAttribute("Bond", bond);
        return "formBond";
    }

    @PostMapping("/saveBond")
    public String saveProperty(@ModelAttribute("Bond") Bond bond){
        bondService.saveBond(bond);

        return "redirect:/propertyList";
    }
}
