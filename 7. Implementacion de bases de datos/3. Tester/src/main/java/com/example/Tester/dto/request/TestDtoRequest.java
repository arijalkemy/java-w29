package com.example.Tester.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDtoRequest {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate lastUpdate;
}
