package com.meli.empleados.Dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class UserDto {
    private String id;
    private String nombre;
}
