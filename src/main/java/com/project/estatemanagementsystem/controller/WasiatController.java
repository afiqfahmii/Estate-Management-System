package com.project.estatemanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.estatemanagementsystem.dto.WasiatDto;
import com.project.estatemanagementsystem.entity.AnakAngkatDetail;
import com.project.estatemanagementsystem.entity.AnakLelakiDetail;
import com.project.estatemanagementsystem.entity.AnakPerempuanDetail;
import com.project.estatemanagementsystem.entity.IsteriDetail;
import com.project.estatemanagementsystem.entity.Property;
import com.project.estatemanagementsystem.entity.User;
import com.project.estatemanagementsystem.entity.Wasiat;
import com.project.estatemanagementsystem.service.PropertyService;
import com.project.estatemanagementsystem.service.UserService;
import com.project.estatemanagementsystem.service.WasiatService;

import jakarta.validation.Valid;

@Controller
public class WasiatController {

    private final UserService userService;
    private final WasiatService wasiatService;
    private final PropertyService propertyService;

    

    public WasiatController(UserService userService, WasiatService wasiatService, PropertyService propertyService) {
        this.userService = userService;
        this.wasiatService = wasiatService;
        this.propertyService = propertyService;
    }

    @GetMapping("/wasiat/create")
    public String showCreateForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getCurrentUser();
        Wasiat wasiat = new Wasiat();
        wasiat.setUser(user);

        model.addAttribute("username", username);
        model.addAttribute("wasiat", wasiat);

        return "createWasiat";
    }

    @PostMapping("/wasiat/create/done")

    public String createWasiat(@ModelAttribute("wasiat") Wasiat wasiat, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getCurrentUser();
        Long userId = user.getId();
        User loggedInUser = getLoggedInUser();
        List<Property> propertyList = propertyService.getPropertiesByUser(loggedInUser);

        model.addAttribute("userId", userId);
        model.addAttribute("username", username);
        model.addAttribute("wasiatShow", wasiat);
        model.addAttribute("loggedInUser", loggedInUser);
        model.addAttribute("propertyList", propertyList);
        wasiatService.saveWasiat(wasiat);
        return "showWasiat";
    }

    @GetMapping("/wasiat/list")
    public String listWasiat(Model model) {
        User loggedInUser = getLoggedInUser();
        List<Wasiat> wasiatList = wasiatService.getWasiatByUser(loggedInUser);
        model.addAttribute("wasiatList", wasiatList);
        return "wasiatList";
    }
    

 


    @GetMapping("/wasiat/view/{userId}")
public String viewWasiat(@PathVariable Long userId, Model model) {
    User loggedInUser = getLoggedInUser();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Property> propertyList = propertyService.getPropertiesByUser(loggedInUser);
        Wasiat wasiat = wasiatService.getWasiatByUserId(userId);

        model.addAttribute("username", username);
        model.addAttribute("userId", userId);
        model.addAttribute("loggedInUser", loggedInUser);
        model.addAttribute("propertyList", propertyList);
        model.addAttribute("wasiatShow", wasiat);

    if (propertyList.isEmpty() && wasiat == null) {
        // Redirect to the error page if both propertyList and wasiat are empty
        return "redirect:/error";
    }

    return "showWasiat";
}


    @GetMapping("/wasiat/details/{userId}")
    public String showWasiatDetails(@PathVariable Long userId, Model model) {
        User user = wasiatService.getWasiatDetailsByUserId(userId);
        Wasiat wasiat = wasiatService.getWasiatByUserId(user.getId());
        List<Property> propertyList = propertyService.getPropertiesByUserId(user.getId());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("username", username);

        if (wasiat != null || propertyList != null && !propertyList.isEmpty()) {
            model.addAttribute("propertyList", propertyList);
            model.addAttribute("wasiat", wasiat);
            return "wasiatDetails";
        } else {
            // Redirect to the error page if both wasiat and propertyList are null
            return "redirect:/error";
        }
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
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit/{userId}")
    public String EditUserWasiat(@PathVariable Long userId, Model model) {
        Wasiat wasiat = wasiatService.getWasiatByUserId(userId);
        if (wasiat == null) {
            return "redirect:/error";
        }
        model.addAttribute("wasiat", wasiat);
        return "updateWasiat";
    }

    @GetMapping("/wasiat/edit/{userId}")
    public String UserEditWasiat(@PathVariable Long userId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Wasiat wasiat = wasiatService.getWasiatByUserId(userId);
        if (wasiat == null) {
            return "redirect:/error";
        }
        model.addAttribute("username", username);
        model.addAttribute("wasiat", wasiat);
        return "userUpdateWasiat";
    }

    @PostMapping("/admin/update")
    public String updateWasiat(@Valid @ModelAttribute Wasiat wasiat, BindingResult bindingResult) {
        List<String> anakLelakiNames = new ArrayList<>();
        List<String> anakPerempuanNames = new ArrayList<>();
        List<String> anakAngkatNames = new ArrayList<>();
        List<String> isteriNames = new ArrayList<>();
        List<String> anakLelakiIcs = new ArrayList<>();
        List<String> anakPerempuanIcs = new ArrayList<>();
        List<String> anakAngkatIcs = new ArrayList<>();
        List<String> isteriIcs = new ArrayList<>();

        for (AnakLelakiDetail anakLelakiDetail : wasiat.getAnakLelakiDetails()) {
            String name = anakLelakiDetail.getName();
            if (anakLelakiNames.contains(name)) {
                return "duplicateNameError";
            }
            anakLelakiNames.add(name);
        }

        for (AnakPerempuanDetail anakPerempuanDetail : wasiat.getAnakPerempuanDetails()) {
            String name = anakPerempuanDetail.getName();
            if (anakPerempuanNames.contains(name) || anakLelakiNames.contains(name)) {
                return "duplicateNameError";
            }
            anakPerempuanNames.add(name);
        }

        for (AnakAngkatDetail anakAngkatDetail : wasiat.getAnakAngkatDetails()) {
            String name = anakAngkatDetail.getName();
            if (anakAngkatNames.contains(name) || anakLelakiNames.contains(name) || anakPerempuanNames.contains(name)) {
                return "duplicateNameError";
            }
            anakAngkatNames.add(name);
        }

        for (IsteriDetail isteriDetail : wasiat.getIsteriDetails()) {
            String name = isteriDetail.getName();
            if (isteriNames.contains(name) || anakLelakiNames.contains(name) || anakPerempuanNames.contains(name) || anakAngkatNames.contains(name)) {
                return "duplicateNameError";
            }
            isteriNames.add(name);
        }

        for (AnakLelakiDetail anakLelakiDetail : wasiat.getAnakLelakiDetails()) {
            String ic = anakLelakiDetail.getIc();
            if (anakLelakiIcs.contains(ic)) {
                return "duplicateIcError";
            }
            anakLelakiIcs.add(ic);
        }

        for (AnakPerempuanDetail anakPerempuanDetail : wasiat.getAnakPerempuanDetails()) {
            String ic = anakPerempuanDetail.getIc();
            if (anakPerempuanIcs.contains(ic) || anakLelakiIcs.contains(ic)) {
                return "duplicateIcError";
            }
            anakPerempuanIcs.add(ic);
        }

        for (AnakAngkatDetail anakAngkatDetail : wasiat.getAnakAngkatDetails()) {
            String ic = anakAngkatDetail.getIc();
            if (anakAngkatIcs.contains(ic) || anakLelakiIcs.contains(ic) || anakPerempuanIcs.contains(ic)) {
                return "duplicateIcError";
            }
            anakAngkatIcs.add(ic);
        }

        for (IsteriDetail isteriDetail : wasiat.getIsteriDetails()) {
            String ic = isteriDetail.getIc();
            if (isteriIcs.contains(ic) || anakLelakiIcs.contains(ic) || anakPerempuanIcs.contains(ic) || anakAngkatIcs.contains(ic)) {
                return "duplicateIcError";
            }
            isteriIcs.add(ic);
        }

        wasiatService.updateWasiat(wasiat);
        return "redirect:/admin";
    }
    @PostMapping("/user/update")
    public String userUpdateWasiat(@Valid @ModelAttribute Wasiat wasiat, BindingResult bindingResult, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getCurrentUser();
        Long userId = user.getId();
        List<String> anakLelakiNames = new ArrayList<>();
        List<String> anakPerempuanNames = new ArrayList<>();
        List<String> anakAngkatNames = new ArrayList<>();
        List<String> isteriNames = new ArrayList<>();
        List<String> anakLelakiIcs = new ArrayList<>();
        List<String> anakPerempuanIcs = new ArrayList<>();
        List<String> anakAngkatIcs = new ArrayList<>();
        List<String> isteriIcs = new ArrayList<>();

        for (AnakLelakiDetail anakLelakiDetail : wasiat.getAnakLelakiDetails()) {
            String name = anakLelakiDetail.getName();
            if (anakLelakiNames.contains(name)) {
                return "duplicateNameError";
            }
            anakLelakiNames.add(name);
        }

        for (AnakPerempuanDetail anakPerempuanDetail : wasiat.getAnakPerempuanDetails()) {
            String name = anakPerempuanDetail.getName();
            if (anakPerempuanNames.contains(name) || anakLelakiNames.contains(name)) {
                return "duplicateNameError";
            }
            anakPerempuanNames.add(name);
        }

        for (AnakAngkatDetail anakAngkatDetail : wasiat.getAnakAngkatDetails()) {
            String name = anakAngkatDetail.getName();
            if (anakAngkatNames.contains(name) || anakLelakiNames.contains(name) || anakPerempuanNames.contains(name)) {
                return "duplicateNameError";
            }
            anakAngkatNames.add(name);
        }

        for (IsteriDetail isteriDetail : wasiat.getIsteriDetails()) {
            String name = isteriDetail.getName();
            if (isteriNames.contains(name) || anakLelakiNames.contains(name) || anakPerempuanNames.contains(name) || anakAngkatNames.contains(name)) {
                return "duplicateNameError";
            }
            isteriNames.add(name);
        }

        for (AnakLelakiDetail anakLelakiDetail : wasiat.getAnakLelakiDetails()) {
            String ic = anakLelakiDetail.getIc();
            if (anakLelakiIcs.contains(ic)) {
                return "duplicateIcError";
            }
            anakLelakiIcs.add(ic);
        }

        for (AnakPerempuanDetail anakPerempuanDetail : wasiat.getAnakPerempuanDetails()) {
            String ic = anakPerempuanDetail.getIc();
            if (anakPerempuanIcs.contains(ic) || anakLelakiIcs.contains(ic)) {
                return "duplicateIcError";
            }
            anakPerempuanIcs.add(ic);
        }

        for (AnakAngkatDetail anakAngkatDetail : wasiat.getAnakAngkatDetails()) {
            String ic = anakAngkatDetail.getIc();
            if (anakAngkatIcs.contains(ic) || anakLelakiIcs.contains(ic) || anakPerempuanIcs.contains(ic)) {
                return "duplicateIcError";
            }
            anakAngkatIcs.add(ic);
        }

        for (IsteriDetail isteriDetail : wasiat.getIsteriDetails()) {
            String ic = isteriDetail.getIc();
            if (isteriIcs.contains(ic) || anakLelakiIcs.contains(ic) || anakPerempuanIcs.contains(ic) || anakAngkatIcs.contains(ic)) {
                return "duplicateIcError";
            }
            isteriIcs.add(ic);
        }

        model.addAttribute("userId", userId);
        model.addAttribute("username", username);
        wasiatService.updateWasiat(wasiat);
        return "users";
    }



    //--------------------------------------------------------------------------------------------------------------------

    

}
