package com.bootcamp.hqlvivo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Accident {

    @Id
    private Long id;
    private String date;
    private Double economicLoss;
    private Long vehicleId;
}
