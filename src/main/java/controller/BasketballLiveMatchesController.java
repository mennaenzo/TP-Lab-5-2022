package controller;

import model.BasketballLiveMatchesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BasketballLiveMatchesService;

import java.io.IOException;

@RestController
@RequestMapping("/BasketballLiveMatches")
public class BasketballLiveMatchesController {
    private final BasketballLiveMatchesService basketballLiveMatchesService;

    @Autowired
    public BasketballLiveMatchesController(BasketballLiveMatchesService basketballLiveMatchesService){
        this.basketballLiveMatchesService = basketballLiveMatchesService;
    }

    @GetMapping("/")
    public ResponseEntity getBasketballLiveMatches() throws IOException, InterruptedException{
        return basketballLiveMatchesService.getBasketballLiveMatches();
    }
}
