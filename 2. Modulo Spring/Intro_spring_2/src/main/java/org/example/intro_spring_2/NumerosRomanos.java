package org.example.intro_spring_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanos {
    @GetMapping("/convertirNumeroRomano/{numero}")
    public String convertirNumeroRomano(@PathVariable Integer numero){
        return convertirNumeroARomano(numero);
    }

    public String convertirNumeroARomano(Integer numero){

        String[] romanos = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] arabigos = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String resultado = "";
        int i = 12;
        while(numero > 0){
            if(arabigos[i] <= numero){
                resultado += romanos[i];
                numero -= arabigos[i];
            }else{
                i--;
            }
        }
        return resultado;
    }






}
