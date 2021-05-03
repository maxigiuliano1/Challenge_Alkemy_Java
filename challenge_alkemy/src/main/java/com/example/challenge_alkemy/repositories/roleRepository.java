package com.example.challenge_alkemy.repositories;

import com.example.challenge_alkemy.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<Role, Long>{
    
}
