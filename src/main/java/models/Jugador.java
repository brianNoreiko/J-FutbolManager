package models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data

@Entity(name = "jugadores")


public class Jugador extends Persona {
    @Override
    public TypePersona typePersona() {
        return TypePersona.JUGADOR;
    }
    @NotNull
    @Column
    private Integer peso;
    @NotNull
    @Column
    private Integer altura;
    @Column
    private Integer goles;
    @Column
    private Integer minutoJugador;
    @Column
    private Date fechaDeNacimiento;
    @ManyToOne(cascade = CascadeType.ALL)
    private Currency currency;


    public float getPesoValue(){
        return getCurrencyValue() * currency.getTypeCurrency().getPesoValue();
    }

    public float getCurrencyValue(){
        return this.currency.getMonto();
    }

}


