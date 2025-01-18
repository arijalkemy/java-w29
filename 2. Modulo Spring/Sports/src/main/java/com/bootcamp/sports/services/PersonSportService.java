package com.bootcamp.sports.services;

import com.bootcamp.sports.dtos.PersonSportDTO;
import com.bootcamp.sports.models.Person;
import com.bootcamp.sports.models.Sport;
import com.bootcamp.sports.repositories.PersonRepository;
import com.bootcamp.sports.repositories.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PersonSportService {

    private final PersonRepository personRepository;
    private final SportRepository sportRepository;
    Map<String, Person> sportPersons = new HashMap<>();

//    public List<PersonSportDTO> listAll() {
//
//    }

    public List<PersonSportDTO> findSportsPersons(){
        List<PersonSportDTO> listDto = new ArrayList<>();

        List<Person> persons = personRepository.getPersons();
        List<Sport> sports = sportRepository.getSports();

        for (int i = 0; i < persons.size(); i++) {
            PersonSportDTO personSportDTO = new PersonSportDTO();
            Sport sport = sportRepository.getSports().get(i);

            personSportDTO.setFirstname(persons.get(i).getFirstname());
            personSportDTO.setSportname(sports.get(i).getName());

            listDto.add(personSportDTO);
        }

    return listDto;

}
