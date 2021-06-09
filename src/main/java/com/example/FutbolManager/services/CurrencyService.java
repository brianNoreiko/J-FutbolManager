package com.example.FutbolManager.services;

import com.example.FutbolManager.Repository.CurrencyRepository;
import com.example.FutbolManager.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service

public class CurrencyService {

    private CurrencyRepository currencyRepository;

    @Autowired
    public void CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

    public void add(Currency currency) { currencyRepository.save(currency);}

    public List<Currency> getAll(){return currencyRepository.findAll();}

    public Currency getCurrencyById(Integer id){return currencyRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));}

    public void removeCurrency (Integer id){currencyRepository.deleteById(id);}
}
