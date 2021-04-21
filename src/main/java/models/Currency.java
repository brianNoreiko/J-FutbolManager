package models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data

@Entity(name = "currency")



public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private TypeCurrency typeCurrency;
    @NotNull
    @NotEmpty(message = "Monto cannot be negative")
    private float monto;
}
