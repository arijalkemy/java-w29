package com.meli.deportistas.repository;

import com.meli.deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository {

    private List<Deporte> deportes = new ArrayList<>();

    public DeporteRepository() {
        deportes.add(new Deporte("Futbol",1));
        deportes.add(new Deporte("Baloncesto",2));
        deportes.add(new Deporte("Ciclismo",3));
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }


}
