package com.example.FutbolManager.Repository;

import com.example.FutbolManager.models.Cumpleanito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CumpleanitoRepository extends JpaRepository<Cumpleanito, Integer> {
}
