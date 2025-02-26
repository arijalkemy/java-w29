package com.sport.deportistas.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Deporte {
    private String nombre;
    private int nivel;
}
