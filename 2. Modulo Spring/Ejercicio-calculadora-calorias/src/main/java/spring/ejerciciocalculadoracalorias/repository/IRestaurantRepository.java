package spring.ejerciciocalculadoracalorias.repository;

import spring.ejerciciocalculadoracalorias.model.Ingrediente;
import spring.ejerciciocalculadoracalorias.model.Plato;

import java.util.List;

public interface IRestaurantRepository {
    Ingrediente getIngredienteByName(String name);
    Plato getPlatoByName(String name);

    List<Ingrediente> getIngredientes();
}
