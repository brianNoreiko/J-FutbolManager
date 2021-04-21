package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "cumpleanitos")
public class Cumpleanito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private LocalDate fecha;
    @OneToOne
    private Persona cumpleaniero;
    @OneToMany
    @JoinColumn("persona_id")
    @Size(max = 10)
    private Set<Persona> invitados;
}
