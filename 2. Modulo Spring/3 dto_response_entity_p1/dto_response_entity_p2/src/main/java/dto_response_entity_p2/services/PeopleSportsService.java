package dto_response_entity_p2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dto_response_entity_p2.dtos.PersonDTO;
import dto_response_entity_p2.entities.Person;
import dto_response_entity_p2.entities.Sport;
import dto_response_entity_p2.repositories.People;
import dto_response_entity_p2.repositories.Sports;

@Service
public class PeopleSportsService {
  private final People people;
  private final Sports sports;

  public PeopleSportsService(
    People people,
    Sports sports
  ){
    this.people = people;
    this.sports = sports;
    this.addPerson(new Person(
      "John", 
      "Doe", 
      25, 
      new Sport("Soccer", "Professional")
    ));
    this.addPerson(new Person(
      "Jane", 
      "Doe", 
      22, 
      new Sport("Basketball", "Amateur")
    ));
    this.addPerson(new Person(
      "Alice", 
      "Doe", 
      20, 
      new Sport("Tennis", "Professional")
    ));
  }

  public Integer addPerson(Person person){
    if(this.sports.findByName(person.getSport().getName()).isEmpty())
      this.sports.addSport(person.getSport());
    return people.addPerson(person);
  }

  public List<PersonDTO> getPeople(){
    return this.people.findAll().stream()
      .map(PersonDTO::from)
      .toList();
  }
}
