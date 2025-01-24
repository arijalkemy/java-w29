package com.melibootcamp.DtoDeportes.repository;

import com.melibootcamp.DtoDeportes.entity.Person;

public interface IPersonRepository {
    //NO LO ESTOY USANDO PARA PODER HACE LA INICIACION DE LOS DATOS EN EL MAIN
    public  void addPerson(Person person);
    public  Person findPerson(String name);

}
