package dto_response_entity_p2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
  private String name;
  private String lastname;
  private Integer age;
  private Sport sport;
}
