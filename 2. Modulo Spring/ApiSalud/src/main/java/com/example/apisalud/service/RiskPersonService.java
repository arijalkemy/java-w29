package com.example.apisalud.service;

import com.example.apisalud.model.dto.response.RiskPersonResponse;
import com.example.apisalud.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskPersonService {
    private final PersonRepository personRepository = new PersonRepository();

    public List<RiskPersonResponse> getAll() {
        return  personRepository.getAll().stream()
                .filter(person -> person.getAge() > 60 && (person.getSymptoms() != null || person.getSymptoms().size() > 0))
                .map(person -> RiskPersonResponse.builder().name(person.getName()).lastName(person.getLastName()).build())
                .toList();
    }
}
