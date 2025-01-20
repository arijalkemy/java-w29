package org.melibootcamp.concesionario.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.melibootcamp.concesionario.entity.Service;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseUsedDto {
        private Integer id;
        private String brand;
        private LocalDate manufacturingDate;
        private Double numberOfKilometers;
        private Integer doors;
        private Double price;
        private String currency;
        private Integer countOfOwners;
}
