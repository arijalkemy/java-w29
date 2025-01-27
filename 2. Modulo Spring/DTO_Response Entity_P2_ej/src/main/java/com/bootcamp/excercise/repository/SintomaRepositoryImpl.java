package com.bootcamp.excercise.repository;

import com.bootcamp.excercise.entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepositoryImpl implements SintomaRepository{
    private List<Sintoma> sintomas = new ArrayList<>();

    public SintomaRepositoryImpl() {
        sintomas.add(new Sintoma("S01","Sin olfato", "Alto"));
        sintomas.add(new Sintoma("S02","Dolor de cabez", "Bajo"));
        sintomas.add(new Sintoma("S03","Fiebre", "Moderado"));
    }

    @Override
    public List<Sintoma> findAllSymptoms() {
        return sintomas;
    }

    @Override
    public Sintoma findByName(String nombre) {
        for(Sintoma s : sintomas){
            if(s.getNombre().equalsIgnoreCase(nombre)){
                return s;
            }
        }
        return null;
    }
}
