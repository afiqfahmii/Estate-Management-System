package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.RightOfWay;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.RightOfWayService;

public class RightOfWayController implements PropertyBuilder<RightOfWay>{
    @Autowired
    private RightOfWayService rightOfWayService;
    @Autowired
    private UserService userService;

    @GetMapping("/formProperty?type=rightofway")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property rightOfWay = new RightOfWay();
        rightOfWay.setUser(loggedInUser);

        model.addAttribute("RightOfWay", rightOfWay);
        return "formProperty";
    }

    @PostMapping("/saveRightOfWay")
    public String saveProperty(@ModelAttribute("RightOfWay") RightOfWay rightOfWay){
        rightOfWayService.saveRightOfWay(rightOfWay);

        return "redirect:/propertyList";
    }
}
