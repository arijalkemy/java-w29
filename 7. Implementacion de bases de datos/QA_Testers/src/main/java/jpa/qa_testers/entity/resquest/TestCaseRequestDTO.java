package jpa.qa_testers.entity.resquest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseRequestDTO {
    String description;
    Boolean tested;
    Boolean passed;
    @JsonProperty("number_of_tries")
    Integer numberOfTries;
    @JsonProperty("last_update")
    LocalDate lastUpdate;
}