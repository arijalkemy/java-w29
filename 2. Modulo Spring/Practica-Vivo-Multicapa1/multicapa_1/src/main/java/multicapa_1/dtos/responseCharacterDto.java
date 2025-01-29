package multicapa_1.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class responseCharacterDto {
  private String name;
  private Integer height;
  private Integer mass;
  private String gender;
  private String homeworld;
  private String species;

}
