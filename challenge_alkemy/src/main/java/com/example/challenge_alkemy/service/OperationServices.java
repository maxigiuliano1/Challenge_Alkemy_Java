package com.example.challenge_alkemy.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.challenge_alkemy.model.Materia;
import com.example.challenge_alkemy.model.RegisterMateria;
import com.example.challenge_alkemy.model.Teacher;
import com.example.challenge_alkemy.model.Users;
import com.example.challenge_alkemy.repositories.materiaRepository;
import com.example.challenge_alkemy.repositories.registerMateriaRepository;
import com.example.challenge_alkemy.repositories.teacherRepository;
import com.example.challenge_alkemy.repositories.usersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OperationServices {
    @Autowired
    private materiaRepository repositoriomateria;

    @Autowired
    private registerMateriaRepository repositorioRegisterMateria;

    @Autowired
    private teacherRepository repositorioteacher;

    @Autowired
    private usersRepository usuariosRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Teacher registerTeacher(Teacher t){
        return repositorioteacher.save(t);
    }

    public Materia registerMateria (Materia m){
        return repositoriomateria.save(m);
    }

    public RegisterMateria registerAlumInMateria(RegisterMateria r){
        List<Materia> list = listMateria();
        Boolean isEqual = false;
        //Si la lista no es vacia la recorro y verifico si el horario de la materia a inscribir no coincide con el horario de alguna ya inscripta
        if (!list.isEmpty()) {
            for (Materia m : list) {
                if (r.getMateria().getTime() == m.getTime()){
                    isEqual = true;
                }            
            }
        }
        //En caso de que la bandera isEqual sea falsa me inscribo en la materia, caso contrario lanzo un mensaje de error y retorno null
        try {
            if (isEqual != true) {
                return repositorioRegisterMateria.save(r);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Operacion Invalida, ya estas inscripto en otra materia que se dicta en el mismo horario");
        }
        return null;
    }

    public Users registerUser(Users u){
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return usuariosRepositorio.save(u);
    }

    public List<Materia> listMateria(){
        List<Materia> list = new ArrayList<Materia>();
        Set<Materia> set = new HashSet<Materia>();
        list = repositoriomateria.findAll();
        for (Materia m : list) {
            set.add(m);
        }
        for (Materia m : set) {
            list.add(m);
        }

        return list;
    }

    public String descriptionMateria(Materia m){
        return m.getDescription();
    }

    public String infoMateria(Materia m){
        return m.getInfo();
    }
}
