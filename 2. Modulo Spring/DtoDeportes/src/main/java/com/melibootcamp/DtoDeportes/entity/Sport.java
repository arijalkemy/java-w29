package com.melibootcamp.DtoDeportes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data  @Setter
public class Sport {
    private String name;
    private String level;

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
