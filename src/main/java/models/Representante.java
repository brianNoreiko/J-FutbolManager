package models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "representantes")

public class Representante extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugador_id")
    private List<Jugador> jugadoresList;
    private Integer pesoDeLaBoveda;
    private Integer montoTotal;

}
