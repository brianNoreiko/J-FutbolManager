package com.example.FutbolManager.models;

public enum TypeCurrency{
    EUR("euros", 145.22f),
    USD("dolares", 138.53f);

    private String description;
    private float cotizacion;

    TypeCurrency(String description, float cotizacion) {
        this.description = description;
        this.cotizacion = cotizacion;
    }

    public static TypeCurrency find(String value){
        for (TypeCurrency currency: values()){
            if(currency.toString().equalsIgnoreCase(value)){
                return currency;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid currency type %s", value));
    }
    public String getDescription() {
        return description;
    }

    public Float getCotizacion() { return cotizacion;}
}
