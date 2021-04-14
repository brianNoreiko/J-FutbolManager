package services;


import Repository.RepresentanteRepository;

import models.Representante;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class RepresentanteService {
    private RepresentanteRepository representanteRepository;

    public void addRepresentante(Representante representante) {
        representanteRepository.save(representante);
    }

    public void deleteRepresentante(Integer id) {
        representanteRepository.deleteById(id);
    }

    public Representante getRepresentanteById(Integer id) {
        return representanteRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Representante> getRepresentante() {
        return representanteRepository.findAll();
    }
}