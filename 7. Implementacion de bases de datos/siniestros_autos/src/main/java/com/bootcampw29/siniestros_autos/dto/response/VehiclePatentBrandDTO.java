package com.bootcampw29.siniestros_autos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class VehiclePatentBrandDTO {
    private String patent;
    private String brand;
}
