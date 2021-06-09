package com.example.FutbolManager.models;

public enum TypeProfesion {
    DOCTOR("doctor"),
    ABOGADO("abogado"),
    POLITICO("politico");

    private String description;

    TypeProfesion(String description){this.description = description;}

    public static TypeProfesion find(String value){
        for (TypeProfesion profesion: values()){
            if(profesion.toString().equalsIgnoreCase(value)){
                return profesion;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid profesion type %s", value));
    }
}
