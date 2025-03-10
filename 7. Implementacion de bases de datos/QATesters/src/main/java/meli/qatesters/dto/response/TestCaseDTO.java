package meli.qatesters.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCaseDTO {
    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    Integer number_of_tries;
    LocalDate lastUpdate;
}
