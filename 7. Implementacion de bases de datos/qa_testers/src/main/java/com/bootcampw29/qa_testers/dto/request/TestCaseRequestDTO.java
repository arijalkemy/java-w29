package com.bootcampw29.qa_testers.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCaseRequestDTO {
    @NotNull
    @NotBlank
    private String description;
    private Boolean tested;
    private Boolean passed;
    @Min(0)
    private Integer numberOfTries;
}
