package org.example.ejerciciocovid.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SintomasDto {
   private String nombre;
   private  String nivelDeGravedad;
}
