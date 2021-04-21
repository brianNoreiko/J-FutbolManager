package controllers;

import models.Cumpleanito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.CumpleanitoService;

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
}
