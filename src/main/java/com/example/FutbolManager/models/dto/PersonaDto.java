package com.example.FutbolManager.models.dto;

import com.example.FutbolManager.models.TypePersona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonaDto {
    private Integer id;
    private String name;
    private String lastname;
    private TypePersona typePersona;
}
