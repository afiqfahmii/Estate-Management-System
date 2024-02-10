package com.project.estatemanagementsystem.controller.propertycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.Share;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.ShareService;

public class ShareController implements PropertyBuilder<Share>{
    @Autowired
    private ShareService shareService;
    @Autowired
    private UserService userService;

    @GetMapping("/formProperty?type=share")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property share = new Share();
        share.setUser(loggedInUser);

        model.addAttribute("Share", share);
        return "formProperty";
    }

    @PostMapping("/saveShare")
    public String saveProperty(@ModelAttribute("Share") Share share){
        shareService.saveShare(share);

        return "redirect:/propertyList";
    }
}
