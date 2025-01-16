package com.example.covid.repositories;

import com.example.covid.entity.Sintoma;
import com.example.covid.enums.NivelGravedadEnum;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SintomaRepositoryImpl implements ISintomaRepository{
    List<Sintoma> sintomas;

    public SintomaRepositoryImpl(){
        this.cargarDatos();
    }

    private void cargarDatos(){
        this.sintomas = new ArrayList<>(List.of(
                new Sintoma(1L, "Fiebre", NivelGravedadEnum.ALTO),
                new Sintoma(2L, "Tos", NivelGravedadEnum.MEDIO),
                new Sintoma(3L, "Dolor de cabeza", NivelGravedadEnum.BAJO),
                new Sintoma(4L, "Fatiga", NivelGravedadEnum.MEDIO),
                new Sintoma(5L, "Dificultad para respirar", NivelGravedadEnum.ALTO)
        ));
    }

    @Override
    public Optional<Sintoma> findSymptomByName(String sintoma) {
        return this.sintomas.stream()
                .filter(s -> s.getNombre().contains(sintoma))
                .findFirst();
    }


    @Override
    public List<Sintoma> findSymptom() {
        return this.sintomas;
    }

}
