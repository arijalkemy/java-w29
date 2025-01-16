package dto_response_entity_p2.dtos;

import dto_response_entity_p2.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class PersonDTO {
  private String fullname;
  private String sport_name;

  public static PersonDTO from(Person person){
    return new PersonDTO(
      person.getName()+" "+person.getLastname(), 
      person.getSport().getName()
    );
  }
}
