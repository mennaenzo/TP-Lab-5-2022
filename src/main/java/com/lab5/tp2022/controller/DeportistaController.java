package com.lab5.tp2022.controller;

import com.lab5.tp2022.service.DeportistaService;
import com.lab5.tp2022.model.Deportista;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Deportista")
public class DeportistaController {
    private DeportistaService deportistaService;

    @Autowired
    public DeportistaController (DeportistaService deportistaService){
        this.deportistaService = deportistaService;
    }
    @Operation(summary = "Agrega deportista. @type -> futbolista / basketbolista")
    //@ApiOperation(value = "Agrega deportista.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Deportista agregado exitosamente."),
    })
    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Deportista deportista) {
        return deportistaService.add(deportista);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca deportista por id.")
    public ResponseEntity<Deportista> findById(@PathVariable Integer id){
        return deportistaService.findById(id);
    }

    @GetMapping("/FullName/")
    //@ApiOperation(value = "Busca deportista por nombre completo.")
    @Operation(summary = "Busca deportista por nombre completo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deportista no encontrado."),
    })
    public ResponseEntity<Deportista> findByFullName(@RequestParam String name, String lastName){
        return deportistaService.findByNameLastName(name, lastName);
    }
}
