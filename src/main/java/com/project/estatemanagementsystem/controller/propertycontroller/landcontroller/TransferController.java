package com.project.estatemanagementsystem.controller.propertycontroller.landcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.controller.PropertyBuilder;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.property.land.Transfer;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.propertyservice.landservice.TransferService;

public class TransferController implements PropertyBuilder<Transfer>{
    @Autowired
    private TransferService transferService;
    @Autowired
    private UserService userService;

    @GetMapping("/formtransfer?type=transfer")
    public String showForm(Model model){
        User loggedInUser = userService.getCurrentUser();

        Property transfer = new Transfer();
        transfer.setUser(loggedInUser);

        model.addAttribute("Transfer", transfer);
        return "formProperty";
    }

    @PostMapping("/saveTransfer")
    public String saveProperty(@ModelAttribute("Transfer") Transfer transfer){
        transferService.saveTransfer(transfer);

        return "redirect:/propertyList";
    }
}
