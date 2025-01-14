package org.bootcamp.arquitecturamulticapap2.repository;

import org.bootcamp.arquitecturamulticapap2.dto.response.IngredienteDTO_Out;

public interface IIngredienteRepository {
    IngredienteDTO_Out getByName(String name);
}