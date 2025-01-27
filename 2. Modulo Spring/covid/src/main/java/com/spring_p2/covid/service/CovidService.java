package com.spring_p2.covid.service;

import com.spring_p2.covid.dto.RiskPersonDTO;
import com.spring_p2.covid.dto.SymptomDTO;
import com.spring_p2.covid.model.Person;
import com.spring_p2.covid.model.Symptom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CovidService {
    private final List<Symptom> symptoms;
    private final List<Person> persons;

    public CovidService() {
        symptoms = new ArrayList<>();
        persons = new ArrayList<>();

        Symptom fstSymptom = new Symptom(1, "headache", 1);
        Symptom sndSymptom = new Symptom(2, "sore throat", 2);

        Person fstPerson = new Person(1, "Jonathan", "Joestar", 23, List.of(fstSymptom));
        Person sndPerson = new Person(2, "Joseph", "Joestar", 72, List.of(sndSymptom));
        Person trdPerson = new Person(3, "Mr.", "Polnareff", 62, List.of(fstSymptom, sndSymptom));

        symptoms.add(fstSymptom);
        symptoms.add(sndSymptom);

        persons.add(fstPerson);
        persons.add(sndPerson);
        persons.add(trdPerson);
    }

    public List<SymptomDTO> getSymptoms() {
        return symptoms.stream().map(this::symptomToDTO).toList();
    }

    public Optional<SymptomDTO> getSymptomByName(String name) {
        return this.getSymptoms().stream()
                .filter(s -> s.name().equals(name))
                .findFirst();
    }

    public List<RiskPersonDTO> getRiskPersons() {
        List<Person> riskPersons = persons.stream().filter(this::isRiskPerson).toList();
        return riskPersons.stream().map(this::riskPersonToDTO).toList();
    }

    private boolean isRiskPerson(Person person) {
        return person.getAge() > 60 && !person.getSymptoms().isEmpty();
    }

    // Mappers
    private SymptomDTO symptomToDTO(Symptom symptom) {
        return new SymptomDTO(symptom.getName(), symptom.getSeverity());
    }

    private RiskPersonDTO riskPersonToDTO(Person person) {
        List<SymptomDTO> symptomDTOS = person.getSymptoms().stream().map(this::symptomToDTO).toList();
        return new RiskPersonDTO(person.getFirstName(), person.getLastName(), symptomDTOS);
    }
}
