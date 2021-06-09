package com.example.FutbolManager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {


    @Autowired
    private ApiCallService apiCallService;

    @GetMapping
    public CotizacionApiResponse getDolarCotizacion() throws IOException, InterruptedException{
        return  apiCallService.getDolarCotizacion();
    }

    @GetMapping
    public CotizacionApiResponse getEuroCotizacion() throws IOException, InterruptedException{
        return  apiCallService.getDolarCotizacion();
    }
}
