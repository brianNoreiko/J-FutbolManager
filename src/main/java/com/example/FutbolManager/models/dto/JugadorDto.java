package com.example.FutbolManager.models.dto;

import com.example.FutbolManager.models.Currency;
import com.example.FutbolManager.models.TypePersona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JugadorDto {
    private TypePersona typePersona;
    private Integer peso;
    private Integer altura;
    private Integer minutoJugador;
    private Date fechaDeNacimiento;
    private Currency currency;
}
