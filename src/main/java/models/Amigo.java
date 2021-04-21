package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Amigo extends Persona{

    private TypeProfesion typeProfesion;
    private TypeStatusSocial typeStatusSocial;

    @Override
    public TypePersona typePersona() {
        return TypePersona.AMIGO;
    }
}
