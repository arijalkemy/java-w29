package com.example.apisalud.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class SymptomResponse implements Serializable {
    private Integer severity;
}
