package com.example.joyerialasperlas.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaIdDto {
    @Positive
    @NotNull
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;

    @NotBlank(message = "El material es obligatorio")
    @Size(max = 50, message = "El material no puede tener más de 50 caracteres")
    private String material;

    @NotNull(message = "El peso es obligatorio")
    @Positive(message = "El peso debe ser un número positivo")
    private Double peso;

    @Size(max = 255, message = "La particularidad no puede tener más de 255 caracteres")
    private String particularidad;

    @NotNull(message = "Debe indicar si la joya posee piedra")
    private Boolean posee_piedra;

    @NotNull(message = "Debe indicar si la joya está en venta o no")
    private Boolean ventaONo;
}
