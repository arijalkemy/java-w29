package com.meli.covid19.repository;

import com.meli.covid19.model.SintomaModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SintomaRepository {
    public List<SintomaModel> sintomasList;

    public SintomaRepository() {
        sintomasList = new ArrayList<>();
        sintomasList.add(new SintomaModel(1, "Fiebre", 4));
        sintomasList.add(new SintomaModel(2, "Tos", 1));
        sintomasList.add(new SintomaModel(3, "Dolor", 4));
        sintomasList.add(new SintomaModel(4, "Poca percepción de olores", 1));
        sintomasList.add(new SintomaModel(5, "Congestión nasal", 2));
        sintomasList.add(new SintomaModel(6, "Dolor de cabeza", 3));
        sintomasList.add(new SintomaModel(7, "Cansancio", 2));
        sintomasList.add(new SintomaModel(8, "Dificultad para respirar", 5));
        sintomasList.add(new SintomaModel(9, "Diarrea", 1));
        sintomasList.add(new SintomaModel(10, "Dolor de garganta", 2));
    }
}