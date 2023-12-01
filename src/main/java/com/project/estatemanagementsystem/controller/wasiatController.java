package com.project.estatemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.entity.WasiatForm;
import com.project.estatemanagementsystem.repository.WasiatRepository;

// import ch.qos.logback.core.model.Model;

@Controller
public class wasiatController {
    @Autowired
    private WasiatRepository wasiatRepository;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("formData", new WasiatForm());
        return "form";
    }

    @PostMapping("/form")
    public String processForm(@ModelAttribute WasiatForm formData) {
        // wasiatRepository.save(formData);
        // return "redirect:/success"; // Redirect to a success page
        try {
            wasiatRepository.save(formData);
            // Add logging to check if the save operation was successful
            System.out.println("Form data saved successfully!");
        } catch (Exception e) {
            // Log the exception for troubleshooting
            e.printStackTrace();
        }
        return "redirect:/success";
    }
}
