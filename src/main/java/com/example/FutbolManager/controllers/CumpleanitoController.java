package com.example.FutbolManager.controllers;

import com.example.FutbolManager.models.Cumpleanito;
import com.example.FutbolManager.models.Jugador;
import com.example.FutbolManager.models.Persona;
import com.example.FutbolManager.models.dto.JugadorDto;
import com.example.FutbolManager.services.CumpleanitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RestController
@RequestMapping("/cumpleanito")
public class CumpleanitoController {
    @Autowired
    CumpleanitoService cumpleanitoService;

    @GetMapping
    public List<Cumpleanito> getAllCumples(){return cumpleanitoService.getCumpleanitos();}

    @PostMapping("/")
    public void newCumpleanito(@RequestBody Cumpleanito cumpleanito){cumpleanitoService.addCumpleanito(cumpleanito);}

    @GetMapping("/{id}")
    public Cumpleanito getCumpleanito(@PathVariable Integer id){return cumpleanitoService.getCumpleanitoById(id);}

    @PutMapping("/{id}/persona/{id}")
    public void addCumpleanitoToCumpleaniero(@PathVariable Integer idPersona, @PathVariable Integer idCumpleanito){
        cumpleanitoService.addCumpleanitoToCumpleaniero(idPersona,idCumpleanito);}

     /*   @GetMapping("/personas/pagosFiesta")
    public ResponseEntity<List<JugadorDto>> getListaDePagos(@RequestBody Jugador jugador,
                                                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                            @RequestParam(value = "page", defaultValue = "0") Integer page){
            Pageable pageable = PageRequest.of(page, size); //...?
    }*/
}


}
