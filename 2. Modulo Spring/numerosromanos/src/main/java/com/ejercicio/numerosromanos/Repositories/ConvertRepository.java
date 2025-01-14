package com.ejercicio.numerosromanos.Repositories;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ConvertRepository {
    Map<String, Integer> romanMap = new HashMap<>(Map.ofEntries(
            Map.entry("I", 1),
            Map.entry("II", 2),
            Map.entry("III", 3),
            Map.entry("IV", 4),
            Map.entry("V", 5),
            Map.entry("VII", 7),
            Map.entry("X", 10),
            Map.entry("XIII", 13),
            Map.entry("L", 50),
            Map.entry("C", 100),
            Map.entry("D", 500),
            Map.entry("M", 1000)
    ));

    public Map<String,Integer> getRomanMap() {
        return romanMap;
    }
}
