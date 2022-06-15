package com.lab5.tp2022.controller;

import com.lab5.tp2022.service.DeportistaService;
import com.lab5.tp2022.model.Deportista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deportista")
public class DeportistaController {
    private DeportistaService deportistaService;

    @Autowired
    public DeportistaController (DeportistaService deportistaService){
        this.deportistaService = deportistaService;
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Deportista deportista) {
        return deportistaService.add(deportista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deportista> findById(@PathVariable Integer id){
        return deportistaService.findById(id);
    }

    @GetMapping("/FullName/")
    public ResponseEntity<Deportista> findByFullName(@RequestParam String name, String lastName){
        return deportistaService.findByNameLastName(name, lastName);
    }
}
