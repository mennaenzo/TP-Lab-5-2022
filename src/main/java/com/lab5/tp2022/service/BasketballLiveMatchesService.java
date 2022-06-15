package com.lab5.tp2022.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface BasketballLiveMatchesService {
    ResponseEntity getBasketballLiveMatches() throws IOException, InterruptedException;
}
