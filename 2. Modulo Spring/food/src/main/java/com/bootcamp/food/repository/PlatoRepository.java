package com.bootcamp.food.repository;

import com.bootcamp.food.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlatoRepository {
    private final List<Plato> platos = List.of(
            new Plato("Pizza", List.of(
                    "Queso mozzarella",
                    "Jamón",
                    "Salsa de tomate en conserva"
            )
            )
    );
    public List<Plato> getPlatos(){
        return this.platos;
    }
    public Plato getPlatoByName(String name){
        try{
            return this.platos.stream().filter( plato -> plato.getName().equals(name)).toList().getFirst();
        }catch (RuntimeException e){
            return null;
        }
    }
}
