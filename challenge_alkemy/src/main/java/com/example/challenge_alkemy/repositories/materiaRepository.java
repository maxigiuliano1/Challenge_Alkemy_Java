package com.example.challenge_alkemy.repositories;

import com.example.challenge_alkemy.model.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface materiaRepository extends JpaRepository<Materia, Long> {
    
}
