package com.org.meli.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskGroupPersonDto {
    String name;
    String lastName;
    List<SymptomDto> symptoms;
}
