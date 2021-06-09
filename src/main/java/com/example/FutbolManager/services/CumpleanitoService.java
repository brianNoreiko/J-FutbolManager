package com.example.FutbolManager.services;

import com.example.FutbolManager.Repository.CumpleanitoRepository;
import com.example.FutbolManager.models.Cumpleanito;
import com.example.FutbolManager.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CumpleanitoService {
    private CumpleanitoRepository cumpleanitoRepository;
    private PersonaService personaService;
    @Autowired
    public void CumpleanitoService(CumpleanitoRepository cumpleanitoRepository, PersonaService personaService){
        this.cumpleanitoRepository = cumpleanitoRepository;
        this.personaService = personaService;
    }

    public void addCumpleanito(Cumpleanito cumpleanito){ cumpleanitoRepository.save(cumpleanito);}

    public List<Cumpleanito> getCumpleanitos(){ return cumpleanitoRepository.findAll();}

    public Cumpleanito getCumpleanitoById(Integer id){ return cumpleanitoRepository.findById(id).
            orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));}

    public void addCumpleanitoToCumpleaniero(Integer idPersona, Integer idCumpleanito) {
        Persona persona = personaService.getPersonaById(idPersona);
        Cumpleanito cumpleanito = getCumpleanitoById(idCumpleanito);
        persona.getCumpleanitoSet().add(cumpleanito);
        cumpleanitoRepository.save(cumpleanito);
        personaService.savePersona(persona);
    }

    public void rellenarListaInvitados(List<Persona> personas, Integer idCumpleanito){
        Cumpleanito cumpleanito = getCumpleanitoById(idCumpleanito);
        Set<Persona> invitados = new HashSet<Persona>();
        if((cumpleanito instanceof Cumpleanito) && (personas != null)){
            //Falta terminar
        }

    }

}
