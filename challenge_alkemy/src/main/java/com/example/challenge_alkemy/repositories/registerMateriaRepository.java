package com.example.challenge_alkemy.repositories;

import com.example.challenge_alkemy.model.RegisterMateria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface registerMateriaRepository extends JpaRepository<RegisterMateria, Long>{
    
}
