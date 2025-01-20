package com.example.carDealership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private String date;
    private String kilometers;
    private String descriptions;
}
