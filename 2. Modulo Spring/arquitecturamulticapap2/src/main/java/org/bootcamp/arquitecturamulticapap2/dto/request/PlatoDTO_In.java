package org.bootcamp.arquitecturamulticapap2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO_In {
    private String name;
    private List<IngredienteDTO_in> ingredientes;
    private Double peso;
}