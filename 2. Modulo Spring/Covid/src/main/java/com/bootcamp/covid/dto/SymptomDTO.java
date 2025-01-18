package com.bootcamp.covid.dto;

import com.bootcamp.covid.model.RiskLevel;

public record SymptomDTO(
        String code,
        String name,
        RiskLevel riskLevel
) {
}
