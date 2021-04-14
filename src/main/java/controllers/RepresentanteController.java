package controllers;


import models.Representante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.RepresentanteService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/representante")

public class RepresentanteController {

    @Autowired
    RepresentanteService representanteService;

    @GetMapping
    public void addRepresentante(Representante representante){
        representanteService.addRepresentante(representante);
    }

    @GetMapping
    public List<Representante> getRepresentante() { return representanteService.getRepresentante();}

    @GetMapping
    public Representante getRepresentanteById(@PathVariable Integer id) {return representanteService.getRepresentanteById(id);}

    @GetMapping
    public void deleteRepresentante(@PathVariable Integer id){ representanteService.deleteRepresentante(id);}
}
