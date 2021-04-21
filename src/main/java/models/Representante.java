package models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "representantes")

public class Representante extends Persona {

    @Override
    public TypePersona typePersona(){ return TypePersona.REPRESENTANTE; }


    @OneToMany
    @JoinColumn(name = "jugador_id")
    private List<Jugador> jugadoresList;
    private double pesoDeLaBoveda;
    private float montoTotal;
    @OneToMany
    @JoinColumn(name= "persona_id")
    private List<Persona> amigoList;

    public float getMontoTotal(){
        return jugadoresList.stream().map(Jugador::getPesoValue).reduce((float) 0,Float::sum);
    }

    public float getPesoBoveda(){

        return jugadoresList.stream().map(Jugador::getCurrency).map(Currency::getMonto).
                reduce(0f, (total, element) -> total + (element/100) * 0.1f);
    }


}
