package com.lab5.tp2022.service;

import com.lab5.tp2022.model.Deportista;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

public interface DeportistaService {
    ResponseEntity add(Deportista deportista) throws HttpClientErrorException;
    ResponseEntity<Deportista> findById(Integer id);
    ResponseEntity<Deportista> findByNameLastName(String name, String lastName);
}
