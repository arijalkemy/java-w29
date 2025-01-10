package com.example.codigo_morze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
public class CodigoMorze {

    @GetMapping("codigo-morze/{codigo}")
    public String traducirCodigoMorze(@PathVariable String codigo){
        Map<String,String> letras = new HashMap<>();
        letras.put("._","a");
        letras.put("_...","b");
        letras.put("_._.","c");
        letras.put("_..","d");
        letras.put(".","e");
        letras.put(".._.","f");
        letras.put("__.","g");
        letras.put("....","h");
        letras.put("..","i");
        letras.put(".___","j");
        letras.put("_._","k");
        letras.put("._..","l");
        letras.put("__","m");
        letras.put("_.","n");
        letras.put("___","o");
        letras.put("__._","q");
        letras.put("._.","r");
        letras.put("...","s");
        letras.put("_","t");
        letras.put(".._","u");
        letras.put("..._","v");
        letras.put(".__","w");
        letras.put("_.._","x");
        letras.put("_.__","y");
        letras.put("__..","z");

        String codigo2 = codigo.replaceAll("   ","/");
        String palabra = "";
        String cod = "";

        for (int i = 0; i < codigo2.length(); i++) {
            char c = codigo2.charAt(i);

            if (c == ' ') {
                palabra += letras.get(cod); //Agrego la palabra
                cod = ""; //Resteo el codigo
            } else if (c == '/') {
                palabra += letras.get(cod) + " "; //Agrego la palabra anterior y un espacio
                cod = "";
            } else {
                cod += c;
            }
        }
        palabra += letras.get(cod); //Si termina de recorrer y no encontro un espacio, no agrego la palabra
        //la agrego aca

        return palabra;
    }
}
