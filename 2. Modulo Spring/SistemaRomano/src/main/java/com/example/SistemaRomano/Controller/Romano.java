package com.example.SistemaRomano.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Romano {

    @GetMapping("/romano/{n_decimal}")
    public String decimalToRomano(@PathVariable int n_decimal) {
        StringBuilder romano = new StringBuilder();

        String[] miles = { "", "M", "CM", "D", "CD" };
        String[] cientos = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] decenas = { "", "X", "XX", "XXX", "LV", "L", "LX", "LXX", "LXXX", "XC" };
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

        romano.append(miles[n_decimal / 1000]);
        romano.append(cientos[(n_decimal % 1000) / 100]);
        romano.append(decenas[(n_decimal % 100) / 10]);
        romano.append(unidades[n_decimal % 10]);

        return romano.toString();
    }
}
