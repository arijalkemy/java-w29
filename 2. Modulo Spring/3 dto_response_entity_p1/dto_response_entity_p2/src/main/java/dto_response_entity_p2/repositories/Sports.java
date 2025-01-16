package dto_response_entity_p2.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dto_response_entity_p2.entities.Sport;

@Repository
public class Sports {
  private List<Sport> sports = new ArrayList<>();

  public Integer addSport(Sport sport){
    this.sports.add(sport);
    return this.sports.indexOf(sport);
  }

  public List<Sport> findAll(){
    return this.sports;
  }

  public Optional<Sport> findByName(String name){
    return this.sports.stream()
      .filter(sport -> sport.getName().toLowerCase().contains(name.toLowerCase()))
      .findFirst();
  }
}
