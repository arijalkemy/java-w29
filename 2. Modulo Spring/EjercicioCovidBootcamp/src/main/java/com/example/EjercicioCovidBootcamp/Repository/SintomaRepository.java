package com.example.EjercicioCovidBootcamp.Repository;

import com.example.EjercicioCovidBootcamp.Entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomaRepository implements ISintomaRepository{
    List<Sintoma> sintomaList = new ArrayList<>();
    Sintoma sintoma = new Sintoma(1,"ab","2");
    Sintoma sintoma2 = new Sintoma(2,"cd","3");
    Sintoma sintoma3 = new Sintoma(3,"ef","4");
    public List<Sintoma> findSintomas(){
        sintomaList.add(sintoma);
        sintomaList.add(sintoma2);
        sintomaList.add(sintoma3);
        return sintomaList;
    }
}
