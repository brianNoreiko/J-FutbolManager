package models;

public enum TypeCurrency{
    EUR("euros", 111f),
    USD("dolares", 92.67f);

    private String description;
    private float valorPeso;

    TypeCurrency(String description, float pesoValue) {
        this.description = description;
        this.valorPeso = pesoValue;
    }

    public static TypeCurrency find(String value){
        for (TypeCurrency currency: values()){
            if(currency.toString().equals(value)){
                return currency;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid currency type %s", value));
    }
    public String getDescription() {
        return description;
    }

    public Float getPesoValue() {
        return valorPeso;
    }
}
