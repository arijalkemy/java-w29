package com.thiagoschreck.local.symptom_finder.service;

import com.thiagoschreck.local.symptom_finder.dto.PersonDTO;
import com.thiagoschreck.local.symptom_finder.dto.SymptomDTO;
import com.thiagoschreck.local.symptom_finder.model.Person;
import com.thiagoschreck.local.symptom_finder.model.Symptom;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SymptomFinderService {
    private final List<Symptom> symptoms;
    private final List<Person> persons;

    public SymptomFinderService() {
        final Symptom symptom1 = new Symptom(123, "Fever", 2);
        final Symptom symptom2 = new Symptom(321, "Headaches", 1);

        final Person person1 = new Person(1, "Johnny", "Test", 20, List.of(symptom1, symptom2));
        final Person person2 = new Person(2, "Lorena", "Ipsum", 19, List.of(symptom1));
        final Person person3 = new Person(3, "Logan", "Oldman", 61, List.of(symptom1, symptom2));
        final Person person4 = new Person(4, "Mirtha", "Legrand", 99, List.of(symptom2));

        symptoms = List.of(symptom1, symptom2);
        persons = List.of(person1, person2, person3, person4);
    }

    public List<SymptomDTO> getAllSymptoms() {
        return symptoms.stream()
                .map(this::mapToDTO)
                .toList();
    }

    public Optional<SymptomDTO> findSymptom(String name) {
        return symptoms.stream().filter(symptom -> symptom.name().equalsIgnoreCase(name))
                .map(this::mapToDTO)
                .findFirst();
    }

    public List<PersonDTO> getAllAtRiskPersons() {
        return persons.stream()
                .filter(person -> person.age() > 60)
                .map(this::mapToDTO)
                .toList();
    }

    private SymptomDTO mapToDTO(Symptom symptom) {
        return new SymptomDTO(symptom.name(), symptom.gravityLevel());
    }

    private PersonDTO mapToDTO(Person person) {
        return new PersonDTO(person.name(), person.lastname(), person.age(),
                person.symptoms().stream()
                        .map(this::mapToDTO).toList());
    }
}
