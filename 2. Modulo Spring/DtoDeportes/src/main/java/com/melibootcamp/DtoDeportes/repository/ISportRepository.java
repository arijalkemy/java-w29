package com.melibootcamp.DtoDeportes.repository;

import com.melibootcamp.DtoDeportes.entity.Person;
import com.melibootcamp.DtoDeportes.entity.Sport;

import java.util.List;
//NO LO ESTOY USANDO PARA PODER HACE LA INICIACION DE LOS DATOS EN EL MAIN
public interface ISportRepository {
    public  void addSport(Sport sport);
    public  Sport findSport(String name);
    public  void setSports(List<Sport> sports);
    public  List<Sport> getSports();
}
