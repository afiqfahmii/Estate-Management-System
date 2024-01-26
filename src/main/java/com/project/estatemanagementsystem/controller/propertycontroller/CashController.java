package com.project.estatemanagementsystem.controller.propertycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Cash;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.CashService;

public class CashController implements PropertyBuilder<Cash>{
    @Autowired
    private CashService cashService;
    @Autowired
    private UserService userService;

    @GetMapping("/formcash")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property cash = new Cash();
        cash.setUser(loggedInUser);

        model.addAttribute("Cash", cash);
        return "formCash";
    }

    @PostMapping("/saveCash")
    public String saveProperty(@ModelAttribute("Cash") Cash cash){
        cashService.saveCash(cash);

        return "redirect:/propertyList";
    }
}
