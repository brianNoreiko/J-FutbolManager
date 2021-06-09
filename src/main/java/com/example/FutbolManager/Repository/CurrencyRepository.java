package com.example.FutbolManager.Repository;

import com.example.FutbolManager.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository  extends JpaRepository<Currency,Integer> {
}
