package com.project.estatemanagementsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.dto.WasiatDto;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.Wasiat;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.WasiatService;

@Controller
public class WasiatController {

    private final UserService userService;
    private final WasiatService wasiatService;
    

    public WasiatController(UserService userService, WasiatService wasiatService) {
        this.userService = userService;
        this.wasiatService = wasiatService;
    }

    @GetMapping("/wasiat/create")
    public String showCreateForm(Model model) {
        User loggedInUser = getLoggedInUser();

        WasiatDto wasiat = new WasiatDto();
        wasiat.setUser(loggedInUser);

        model.addAttribute("wasiat", wasiat);

        return "createWasiat";
    }

    @PostMapping("/wasiat/create")
    public String createWasiat(@ModelAttribute("wasiat") Wasiat wasiat, Model model) {
        
        wasiatService.saveWasiat(wasiat);
        model.addAttribute("wasiatPost", wasiat);

        return "postWasiat";
    }

    @GetMapping("/wasiat/list")
    public String listWasiat(Model model) {
        User loggedInUser = getLoggedInUser();
        List<Wasiat> wasiatList = wasiatService.getWasiatByUser(loggedInUser);
        model.addAttribute("wasiatList", wasiatList);

        return "wasiatList";
    }

    @GetMapping("/wasiat/show/{userId}")
    public String showUserWasiatList(@PathVariable Long userId, Model model) {
        Wasiat wasiat = wasiatService.getWasiatByUserId(userId);
        model.addAttribute("wasiatShow", wasiat);
        return "showWasiat";
    }
    // @GetMapping("/wasiat/update/{id}")
    // public String showUpdateForm(@PathVariable Long id, Model model) {
    // Wasiat wasiat = wasiatService.findWasiatById(id);
    // model.addAttribute("wasiat", wasiat);
    // return "updateWasiat";
    // }

    // @PostMapping("/wasiat/update/{id}")
    // public String updateWasiat(@PathVariable("id") Long id,
    // @ModelAttribute("wasiat") WasiatDto wasiatDto) {
    // wasiatService.updateWasiat(id, wasiatDto.getContent());
    // return "redirect:/wasiat/list";
    // }

    @GetMapping("/wasiat/delete/{id}")
    public String deleteWasiat(@PathVariable Long id) {
        wasiatService.deleteWasiat(id);
        return "redirect:/wasiat/list";
    }

    private User getLoggedInUser() {
        return userService.getCurrentUser();
    }

    // ? ADMIN --------------------------------------------------------------------


    @GetMapping("/admin/list")
    public String listAllWasiat(Model model) {
        List<WasiatDto> wasiatList = wasiatService.getAllWasiat();
        model.addAttribute("wasiatList", wasiatList);
        return "adminwasiat";
    }

    @GetMapping("/admin/delete/{userId}")
    public String deleteUserWasiatList(@PathVariable Long userId) {
        wasiatService.deleteUserWasiat(userId);
        return "redirect:/admin/list";
    }

    // -------------------------------------------------------

    @GetMapping("/admin/edit/{userId}")
    public String EditUserWasiat(@PathVariable Long userId, Model model) {

        Wasiat wasiat = wasiatService.getWasiatByUserId(userId);

        if (wasiat == null) {

            return "redirect:/error";
        }

        model.addAttribute("wasiat", wasiat);
        return "updateWasiat";
    }

    @PostMapping("/admin/update")
    public String updateWasiat(@ModelAttribute Wasiat wasiat) {
        wasiatService.updateWasiat(wasiat);
        return "redirect:/admin/list";
    }

}
