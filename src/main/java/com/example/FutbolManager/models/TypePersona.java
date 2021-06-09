package com.example.FutbolManager.models;

public enum TypePersona {
    JUGADOR("jugador"),
    REPRESENTANTE("representante"),
    AMIGO("soy un amigo");

    private String description;

    TypePersona(String description){ this.description = description;}

    public static TypePersona find(String value){
        for (TypePersona persona: values()){
            if(persona.toString().equalsIgnoreCase(value)){
                return persona;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid person type %s", value));
    }

    public String getDescription() {
        return description;
    }
}
