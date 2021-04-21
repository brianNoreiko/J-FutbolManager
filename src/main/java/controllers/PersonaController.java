package controllers;

import models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.PersonaService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/persona")

public class PersonaController {
    @Autowired
    PersonaService personaService;

    @PostMapping
    public void addPersona(@RequestBody Persona persona) {
        personaService.savePersona(persona);
    }

    @GetMapping
    public List<Persona> getPersonas() {
        return personaService.getPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Integer id) {
        return personaService.getPersonaById(id);
    }

    @DeleteMapping
    public void deletePersona(@PathVariable Integer id) {
        personaService.deletePersona(id);
    }

    @PutMapping("/jugador/{id}/jugadores/{idJugador}")
    public void addJugToRepr(@PathVariable Integer id, @PathVariable Integer idJugador) {
        personaService.addJugToRepr(id, idJugador);
    }
    @PutMapping("/representante/{id}/cumpleanito/{idPersona}")
    public void addPersonaToRepresentante(@PathVariable Integer idPersona, @PathVariable Integer idRepresentante){
        personaService.addPersonaToRepresentante(idPersona,idRepresentante);}
}
