package controllers;

import models.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.JugadorService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/jugador")

public class JugadorController {
    @Autowired
    JugadorService jugadorService;

    @GetMapping
    public void addJugador(Jugador jugador){
        jugadorService.addJugador(jugador);
    }

    @GetMapping
    public List<Jugador> getJugadores() { return jugadorService.getJugadores();}

    @GetMapping
    public Jugador getJugadorById(@PathVariable Integer id) {return jugadorService.getJugById(id);}

    @GetMapping
    public void deleteJugador(@PathVariable Integer id){ jugadorService.deleteJugador(id);}

    /*@GetMapping("/jugador/{id}/jugadores/{idJugador}")
    public void updateJug(Jugador jugador){jugadorService.UpdateJugador(jugador)}*/

}
