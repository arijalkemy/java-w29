package org.meli.qatesters.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseDTO {
    String description;
    Boolean tested;
    Boolean passed;
    @JsonProperty("number_of_tries")
    int numberOfTries;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @JsonProperty("last_update")
    LocalDate lastUpdate;
}
