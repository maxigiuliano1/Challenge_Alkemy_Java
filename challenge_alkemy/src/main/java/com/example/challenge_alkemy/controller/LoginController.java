package com.example.challenge_alkemy.controller;

import com.example.challenge_alkemy.model.Users;
import com.example.challenge_alkemy.service.OperationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private OperationServices operationServices;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new Users());        
        return "login";
    }

    @GetMapping("/")
    public String registroForm(Model model){
        model.addAttribute("user", new Users());
        return "inicio";
    }

    @PostMapping("/")
    public String registro(@Validated @ModelAttribute Users user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/";
        }
        else{
            model.addAttribute("user", operationServices.registerUser(user));
        }

        return "redirect:/login";
    }
}
