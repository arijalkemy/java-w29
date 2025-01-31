package com.meli.obtenerdiploma.model;


import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ErrorDTO {
    private String name;
    private String description;
}
