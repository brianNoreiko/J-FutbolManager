package com.example.FutbolManager.Repository;

import com.example.FutbolManager.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
