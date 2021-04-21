package models;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.AccessType;

import java.util.Set;

@Data

@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typePerson", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Jugador.class, name = "JUGADOR"),
        @JsonSubTypes.Type(value = Representante.class, name = "REPRESENTANTE")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column()
    private String name;
    @NotNull
    @Column
    private String lastname;
    @ManyToMany
    @JoinTable(name = "cumpleanitos",
            joinColumns = @JoinColumn(name = "cumpleanito_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<Cumpleanito> cumpleanitoSet;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypePersona typePersona();
}
