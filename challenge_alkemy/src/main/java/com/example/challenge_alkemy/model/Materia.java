package com.example.challenge_alkemy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materias")
public class Materia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String time;
    private String info;
    private String description;

    @OneToOne()
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
    private Integer studentQuota;

    public Materia(){
        super();
    }

    /**
     * @param id
     * @param name
     * @param time
     * @param teacher
     * @param studentQuota
     */
    public Materia(Long id, String name, String time, Teacher teacher, Integer studentQuota, String info, String description) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.teacher = teacher;
        this.studentQuota = studentQuota;
        this.info = info;
        this.description = description;
    }

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @return the studentQuota
     */
    public Integer getStudentQuota() {
        return studentQuota;
    }

    /**
     * @param studentQuota the studentQuota to set
     */
    public void setStudentQuota(Integer studentQuota) {
        this.studentQuota = studentQuota;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    private static final long serialVersionUID = 1L;
    
}
