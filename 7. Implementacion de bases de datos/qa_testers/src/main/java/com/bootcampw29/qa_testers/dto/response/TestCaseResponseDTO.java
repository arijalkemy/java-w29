package com.bootcampw29.qa_testers.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class TestCaseResponseDTO {
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    private LocalDate lastUpdate;
}
