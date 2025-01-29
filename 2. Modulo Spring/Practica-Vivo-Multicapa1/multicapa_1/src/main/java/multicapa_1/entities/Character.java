package multicapa_1.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class Character {
  private String name;
  private Integer height;
  private Integer mass;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private String species;

  public Character(String name, String height, String mass, String hair_color, String skin_color, String eye_color,
      String birth_year, String gender, String homeworld, String species) {
    this.name = name;
    this.height = Integer.parseInt(height);
    this.mass = Integer.parseInt(mass);
    this.hair_color = hair_color;
    this.skin_color = skin_color;
    this.eye_color = eye_color;
    this.birth_year = birth_year;
    this.gender = gender;
    this.homeworld = homeworld;
    this.species = species;
  }
}
