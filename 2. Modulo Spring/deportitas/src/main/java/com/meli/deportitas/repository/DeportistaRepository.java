package com.meli.deportitas.repository;

import com.meli.deportitas.model.DeportistaDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeportistaRepository {

    private List<DeportistaDTO> deportistaDTOS = new ArrayList<>();

    public DeportistaRepository() {
        deportistaDTOS.add(new DeportistaDTO("Jose","Cruz","Futbol"));
    }

    public List<DeportistaDTO> getDeportistaDTOS() {
        return deportistaDTOS;
    }
}
