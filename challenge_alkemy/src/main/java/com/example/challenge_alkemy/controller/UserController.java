package com.example.challenge_alkemy.controller;

import com.example.challenge_alkemy.model.Materia;
import com.example.challenge_alkemy.model.RegisterMateria;
import com.example.challenge_alkemy.service.OperationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private OperationServices operationServices;

    @GetMapping("/inicio")
    public String home(){
        return "inicioUser";
    }

    //la idea es que se abra una ventana a modo de descripcion/info en la misma url listMaterias
    @GetMapping("/inicio/listMaterias")
    public String listMaterias(@ModelAttribute Materia mat, Model model){
        model.addAttribute("list", operationServices.listMateria());
        model.addAttribute("description", operationServices.descriptionMateria(mat));
        model.addAttribute("info", operationServices.infoMateria(mat));
        return "listMaterias";
    }

    @PostMapping("/inicio/listMaterias")
    public String inscriptionMateria(@ModelAttribute RegisterMateria student, Model model){
        model.addAttribute("inscription", operationServices.registerAlumInMateria(student));
        return "redirect:/user/inicio";
    }
    
}
