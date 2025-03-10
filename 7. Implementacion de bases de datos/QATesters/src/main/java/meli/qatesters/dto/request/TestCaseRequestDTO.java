package meli.qatesters.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseRequestDTO {

    String description;
    Boolean tested;
    Boolean passed;
    Integer number_of_tries;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate lastUpdate;
}
