package com.thiagoschreck.local.symptom_finder.dto;

import java.util.List;

public record PersonDTO(String name, String lastname, int age, List<SymptomDTO> symptoms) {
}
