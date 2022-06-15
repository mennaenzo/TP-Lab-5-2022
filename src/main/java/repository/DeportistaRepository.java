package repository;

import model.Deportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeportistaRepository extends JpaRepository<Deportista,Integer> {
    Deportista findByNameLastName(String name, String lastName);
}
