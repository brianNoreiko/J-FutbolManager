package com.example.FutbolManager.api;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;


@Service
public class ApiCallService {

    public CotizacionApiResponse getDolarCotizacion() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri((URI.create("https://www.dolarsi.com/api/api.php?type=dolar")))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), CotizacionApiResponse.class);
    }

    public CotizacionApiResponse getEuroCotizacion() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri((URI.create("https://www.dolarsi.com/api/api.php?type=genedolar&opc=ta")))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), CotizacionApiResponse.class);
    }
}
