package controllers;

import models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.CurrencyService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @GetMapping
    public void addCurrency(@RequestBody Currency currency){currencyService.add(currency);}

    @GetMapping
    public List<Currency> getAllCurrencies(){return currencyService.getAll();}

    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Integer id){return currencyService.getCurrencyById(id);}

    @GetMapping
    public void deleteCurrencyById(@PathVariable Integer id){currencyService.removeCurrency(id);}
}
