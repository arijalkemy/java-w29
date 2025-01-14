package org.bootcamp.arquitecturamulticapap2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Ingrediente {
    private String name;
    private Integer calories;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ingrediente that = (Ingrediente) o;
        return Objects.equals(name, that.name) && Objects.equals(calories, that.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}