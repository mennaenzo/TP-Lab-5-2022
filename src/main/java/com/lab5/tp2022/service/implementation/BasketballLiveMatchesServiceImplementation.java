package com.lab5.tp2022.service.implementation;

import com.lab5.tp2022.exception.ErrorBody;
import com.lab5.tp2022.model.BasketballLiveMatchesList;
import com.lab5.tp2022.service.BasketballLiveMatchesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.lab5.tp2022.util.JsonBodyHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class BasketballLiveMatchesServiceImplementation implements BasketballLiveMatchesService {

    @Override
    public ResponseEntity<BasketballLiveMatchesList> getBasketballLiveMatches() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sports-live-scores.p.rapidapi.com/basketball/live"))
                .header("X-RapidAPI-Key", "7ecfbaba37mshdc758aed01b152fp1b4866jsna03773c1e8b5")
                .header("X-RapidAPI-Host", "sports-live-scores.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<BasketballLiveMatchesList> response = HttpClient.newHttpClient().send(request, new JsonBodyHandler<>(BasketballLiveMatchesList.class));

        //System.out.println(response.body());

        if (response.body().getMatches().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.OK, "No hay partidos en vivo en este momento.");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(response.body());
        }
    }
}
