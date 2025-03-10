package com.meli.concesionarioseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListVehiculoPatenteDTO {
    private List<String> patentes;
}
