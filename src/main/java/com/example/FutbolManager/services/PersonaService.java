package com.example.FutbolManager.services;


import com.example.FutbolManager.Exceptions.AlreadyExistException;
import com.example.FutbolManager.Repository.PersonaRepository;
import com.example.FutbolManager.models.Jugador;
import com.example.FutbolManager.models.Persona;
import com.example.FutbolManager.models.Representante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public void savePersona(Persona persona) { personaRepository.save(persona);}

    public void deletePersona(Integer id){personaRepository.deleteById(id);}

    public Persona getPersonaById(Integer id){return personaRepository.findById(id).
            orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));}

    public List<Persona> getPersonas(){return personaRepository.findAll();}

    public Persona update(Persona personaP){
        Optional<Persona> persona = Optional.ofNullable(getPersonaById(personaP.getId()));
        if(persona.isPresent()){
            return personaRepository.save(personaP);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    public void addJugToRepr(Integer id, Integer idJugador) {
        Persona rep = getPersonaById(id);
        Persona jugador = getPersonaById(idJugador);
        //Comprobacion de instancia
        if(!(rep instanceof Representante) || !(jugador instanceof Jugador)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            //Comprobacion de duplicado
        }if((((Representante) rep).getJugadoresList().contains(jugador))){
            throw new AlreadyExistException(String.format("Jugador " + idJugador + " "));
        }
        //Agregamos a la lista una vez hechas las comprobaciones anteriores
        ((Representante)rep).getJugadoresList().add((Jugador)jugador);
        personaRepository.save(rep);

    }

    public void addPersonaToRepresentante(Integer idPersona, Integer idRepresentante) {
        Persona rep = getPersonaById(idRepresentante);
        Persona persona = getPersonaById(idPersona);
        //Comprobamos que las ids enviadas sean de las instancias que necesitamos, en caso de que alguna no sea correcta, tiramos exception
        if (!(rep instanceof  Representante) || !(persona instanceof Persona)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            //Chequeamos que la persona no esté ya en la lista de amigos del representate
        }if (((Representante) rep).getAmigoList().contains(persona)){
            throw new AlreadyExistException(String.format("Persona "+ idPersona + " "));
        }
        //Si no se cumplen los "if" anteriores, agregamos la persona a la lista de amigos del representante
        ((Representante) rep).getAmigoList().add(persona);
        personaRepository.save(rep);
    }
}
