package com.bootcamp.hql.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SiniestroDto {
    private Integer id;
    private LocalDate dateOfIncident;
    private BigDecimal economicLoss;
    private Integer vehiculoId;
}
