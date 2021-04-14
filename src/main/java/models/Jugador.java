package models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Calendar;


@Data

@Entity(name = "jugadores")


public class Jugador extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "peso")
    private Integer peso;
    @NotNull
    @Column(name = "altura")
    private Integer altura;
    @Column(name = "goles")
    private Integer goles;
    @Column(name = "minJugador")
    private Time minutoJugador;
    private Currency currency;
    @NotNull
    @Column(name = "fechaNac")
    private Calendar fechaDeNacimiento;
}
