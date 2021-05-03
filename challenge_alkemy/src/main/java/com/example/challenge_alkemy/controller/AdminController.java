package com.example.challenge_alkemy.controller;

import com.example.challenge_alkemy.model.Materia;
import com.example.challenge_alkemy.model.Teacher;
import com.example.challenge_alkemy.service.OperationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private OperationServices operationServices;

    @GetMapping("/inicio")
    public String home(){
        return "inicioAdmin";
    }

    @GetMapping("/registerMateria")
    public String registerMaterias(Model model){
        model.addAttribute("registerMateria", new Materia());
        return "registerMateria";
    }

    @PostMapping("/registerMateria")
    public String saveMateria(@ModelAttribute Materia mat, Model model){
        model.addAttribute("saveMateria", operationServices.registerMateria(mat));
        return "redirect:/admin/inicio";
    }

    @GetMapping("/registerTeacher")
    public String registerTeacher(Model model){
        model.addAttribute("registerTeacher", new Teacher());
        return "registerTeacher";
    }

    @PostMapping("/registerTeacher")
    public String saveTeacher(@ModelAttribute Teacher teach, Model model){
        model.addAttribute("saveTeacher", operationServices.registerTeacher(teach));
        return "redirect:/admin/inicio";
    }
}
