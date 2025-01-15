package com.meli.deportistas.repository;

import com.meli.deportistas.model.DeporteModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository {
    public List<DeporteModel> deportes;

    public DeporteRepository() {
        deportes = new ArrayList<>();
        deportes.add(new DeporteModel(2, "Padel"));
        deportes.add(new DeporteModel(1, "Futbol"));
        deportes.add(new DeporteModel(3, "Baloncesto"));
        deportes.add(new DeporteModel(4, "Golf"));
        deportes.add(new DeporteModel(5, "Moto Velocidad"));
        deportes.add(new DeporteModel(6, "Motocross"));
    }

}
