package services;

import Repository.JugadorRepository;;
import models.Jugador;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class JugadorService {
    private JugadorRepository jugadorRepository;

    public void addJugador(Jugador jugador) { jugadorRepository.save(jugador);}

    public void deleteJugador(Integer id){jugadorRepository.deleteById(id);}

    public Jugador getJugById(Integer id){return jugadorRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));}

    public List<Jugador> getJugadores(){return jugadorRepository.findAll();}

}
