package com.lab5.tp2022.service;

import com.lab5.tp2022.model.BasketballLiveMatchesList;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface BasketballLiveMatchesService {
    ResponseEntity<BasketballLiveMatchesList> getBasketballLiveMatches() throws IOException, InterruptedException;
}
