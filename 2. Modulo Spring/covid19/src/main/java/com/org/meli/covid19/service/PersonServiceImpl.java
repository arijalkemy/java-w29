package com.org.meli.covid19.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.meli.covid19.dto.RiskGroupPersonDto;
import com.org.meli.covid19.dto.SymptomDto;
import com.org.meli.covid19.entity.Person;
import com.org.meli.covid19.entity.Symptom;
import com.org.meli.covid19.repository.IPersonRepository;
import com.org.meli.covid19.repository.ISymptomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {
    private final IPersonRepository personRepository;
    private final ISymptomRepository symptomRepository;

    public PersonServiceImpl(IPersonRepository personRepository, ISymptomRepository symptomRepository) {
        this.personRepository = personRepository;
        this.symptomRepository = symptomRepository;
    }

    @Override
    public List<RiskGroupPersonDto> getListRiskGroupPerson() {
        List<Person> riskGroup = personRepository.findRiskGroup();
        if (riskGroup.isEmpty()) {
            throw new RuntimeException("No se encontraron personas en el grupo de riesgo");
        }
        ObjectMapper mapper = new ObjectMapper();
        return riskGroup.stream()
                .map(person -> new RiskGroupPersonDto(person.getName(), person.getLastName(), symptomRepository.findAll().stream().filter(symptom -> symptom.getSeverity().equals(3)).map(symptom -> mapper.convertValue(symptom, SymptomDto.class)).toList())).toList();
    }
}
