package org.melibootcamp.caloriasejercicio.repositories;

import org.melibootcamp.caloriasejercicio.entities.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDishRepository {

    Optional<Dish> getDishByName(String name);
}
