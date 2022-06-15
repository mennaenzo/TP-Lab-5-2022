package com.lab5.tp2022.repository;

import com.lab5.tp2022.model.Deportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeportistaRepository extends JpaRepository<Deportista,Integer> {
    Deportista findByNombreAndApellido(String name, String lastName);
}
