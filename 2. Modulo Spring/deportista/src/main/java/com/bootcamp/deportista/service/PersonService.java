package com.bootcamp.deportista.service;

import com.bootcamp.deportista.dto.DeportistaDTO;
import com.bootcamp.deportista.domain.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {
    private final Person person1 = new Person("SomePerson", "Healthy", 20);
    //DeportistaDTO deportistaDTO1 = new DeportistaDTO(person1, basket);
    private final Person person2 = new Person("AnotherPerson", "Healthier", 26);
    //DeportistaDTO deportistaDTO2 = new DeportistaDTO(person2, football);
    //List<DeportistaDTO> deportistas = Arrays.asList(deportistaDTO1, deportistaDTO2);
    List<Person> personList = Arrays.asList(person1, person2);
    public Person getPerson(String name){
        return personList.stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
    }
}
