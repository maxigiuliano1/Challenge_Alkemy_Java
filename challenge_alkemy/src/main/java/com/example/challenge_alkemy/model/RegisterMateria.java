package com.example.challenge_alkemy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register_materias")
public class RegisterMateria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Materia materia;
    private Users student;
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the materia
     */
    public Materia getMateria() {
        return materia;
    }
    /**
     * @param materia the materia to set
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    /**
     * @return the student
     */
    public Users getStudent() {
        return student;
    }
    /**
     * @param student the student to set
     */
    public void setStudent(Users student) {
        this.student = student;
    }
    /**
     * @param id
     * @param materia
     * @param student
     */
    public RegisterMateria(Long id, Materia materia, Users student) {
        super();
        this.id = id;
        this.materia = materia;
        this.student = student;
    }
    /**
     * 
     */
    public RegisterMateria() {
        super();
    }
    
    private static final long serialVersionUID = 1L;

}
