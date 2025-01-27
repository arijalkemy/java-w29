package com.spring_p2.covid.dto;

import java.io.Serializable;
import java.util.List;

public record RiskPersonDTO(
    String firstName,
    String lastName,
    List<SymptomDTO> symptoms
) {}
