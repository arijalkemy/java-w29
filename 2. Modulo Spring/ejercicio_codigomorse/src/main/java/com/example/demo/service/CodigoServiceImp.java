package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CodigoServiceImp implements CodigoSerivice{
    @Override
    public String generarCodigo(String frase) {
        // Mapa con letras y sus equivalentes en código
        Map<String, String> mapa = new HashMap<>();
        mapa.put("A", ".-");
        mapa.put("B", "-...");
        mapa.put("C", "-.-.");
        mapa.put("D", "-..");
        mapa.put("E", ".");
        mapa.put("F", "..-.");
        mapa.put("G", "--.");
        mapa.put("H", "....");
        mapa.put("I", "..");
        mapa.put("J", ".---");
        mapa.put("K", "-.-");
        mapa.put("L", ".-..");
        mapa.put("M", "--");
        mapa.put("N", "-.");
        mapa.put("O", "---");
        mapa.put("P", ".--.");
        mapa.put("Q", "--.-");
        mapa.put("R", ".-.");
        mapa.put("S", "...");
        mapa.put("T", "-");
        mapa.put("U", "..-");
        mapa.put("V", "...-");
        mapa.put("W", ".--");
        mapa.put("X", "-..-");
        mapa.put("Y", "-.--");
        mapa.put("Z", "--..");
        mapa.put("1", ".----");
        mapa.put("2", "..---");
        mapa.put("3", "...--");
        mapa.put("4", "....-");
        mapa.put("5", ".....");
        mapa.put("6", "-....");
        mapa.put("7", "--...");
        mapa.put("8", "---..");
        mapa.put("9", "----.");
        mapa.put("0", "-----");
        mapa.put("?", "..--..");
        mapa.put("!","-.-.--");
        mapa.put(".",".-.-.-");
        mapa.put(",","--..--");
        mapa.put(" ","   ");


        // Cadena para construir el resultado
        StringBuilder codigo = new StringBuilder();

        // Convertir el código
        for (char caracter : frase.toUpperCase().toCharArray()) {
            String letra = String.valueOf(caracter);
            if (mapa.containsKey(letra)) {
                codigo.append(mapa.get(letra)).append(" "); // Un espacio entre cada letra
            } else {
                // Si el caracter no está en el mapa, se ignora o se usa un marcador como '?'
                codigo.append("? ");
            }
        }

        // Eliminar el espacio extra al final
        return codigo.toString().trim();

    }
}
