package dto_response_entity_p2.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dto_response_entity_p2.entities.Person;

@Repository
public class People {
  private List<Person> people = new ArrayList<>();

  public Integer addPerson(Person person){
    this.people.add(person);
    return this.people.indexOf(person);
  }

  public List<Person> findAll(){
    return this.people;
  }
}
