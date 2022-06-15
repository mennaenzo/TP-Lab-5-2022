package service.implementation;

import model.Deportista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import repository.DeportistaRepository;
import service.DeportistaService;

import static util.EntityURLBuilder.buildURL;

@Service
public class DeportistaServiceImplementation implements DeportistaService {
    private final DeportistaRepository deportistaRepository;

    @Autowired
    public DeportistaServiceImplementation(DeportistaRepository deportistaRepository) {
        this.deportistaRepository = deportistaRepository;
    }

    @Override
    public ResponseEntity add(Deportista deportistaR) throws HttpClientErrorException {
        if (findByNameLastName(deportistaR.getNombre(), deportistaR.getApellido()) == null)
        {
            Deportista deportista = deportistaRepository.save(deportistaR);

            String PATH = "deportista";
            return ResponseEntity.status(HttpStatus.CREATED).location(buildURL(PATH, deportista.getId().toString())).build();
        }else{
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Ya existe el mismo deportista");
        }
    }

    @Override
    public ResponseEntity<Deportista> findById(Integer id) {
        Deportista deportista = deportistaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.CONFLICT, "This Deportista not exist"));

        return ResponseEntity.status(HttpStatus.OK).body(deportista);
    }

    @Override
    public ResponseEntity<Deportista> findByNameLastName(String name, String lastName) {
        Deportista deportista = deportistaRepository.findByNameLastName(name, lastName);
        return deportista == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(deportista);
    }
}
