package com.project.estatemanagementsystem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping("/")
    public String Index() {
        return "Welcome to the Estate Management System";
    }
    
}
