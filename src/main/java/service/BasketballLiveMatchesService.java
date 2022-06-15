package service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface BasketballLiveMatchesService {
    ResponseEntity getBasketballLiveMatches() throws IOException, InterruptedException;
}
