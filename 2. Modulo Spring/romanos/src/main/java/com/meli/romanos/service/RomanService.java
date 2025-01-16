package com.meli.romanos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanService {
    List<Map.Entry<Integer, String>> romanosArray = List.of(
            Map.entry(1000, "M"),
            Map.entry(900, "CM"),
            Map.entry(500, "D"),
            Map.entry(400, "CD"),
            Map.entry(100, "C"),
            Map.entry(90, "XC"),
            Map.entry(50, "L"),
            Map.entry(40, "XL"),
            Map.entry(10, "X"),
            Map.entry(9, "IX"),
            Map.entry(5, "V"),
            Map.entry(4, "IV"),
            Map.entry(1, "I")
    );

    public String intToRoman(Integer number){
        String roman = "";
        for(Map.Entry<Integer, String> element:romanosArray) {
            double divisionResult = (number / element.getKey());
            int result = (int) Math.floor(divisionResult);
            roman += element.getValue().repeat(result);
            number -= element.getKey()*result;
        }
        return roman;
    }
}
