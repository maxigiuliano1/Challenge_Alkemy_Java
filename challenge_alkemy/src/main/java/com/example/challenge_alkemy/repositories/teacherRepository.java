package com.example.challenge_alkemy.repositories;

import com.example.challenge_alkemy.model.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teacherRepository extends JpaRepository<Teacher, Long>{
    
}
