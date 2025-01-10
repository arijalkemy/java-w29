package exercise.numero_factorial.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @GetMapping("/obtener-factorial/{numero}")
    public int getFactorial(@PathVariable("numero") Integer numero) {
        long factorial = 1;

        if (numero < 0){
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }

        if(numero == 0 || numero == 1){
            return 1;
        }

        return numero * getFactorial(numero - 1);
    }
}
