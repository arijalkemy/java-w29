package com.example.IntroSpring.entity;

import java.util.HashMap;
import java.util.Map;

public class DiccionarioMorse {

   private  Map<String, String> diccionario;
       public DiccionarioMorse(){
        diccionario=new HashMap<>();
        diccionario.put(".-", "A");
        diccionario.put("-...", "B");
        diccionario.put("-..", "D");
        diccionario.put(".", "E");
        diccionario.put("..-.", "F");
        diccionario.put("--.", "G");
        diccionario.put("....", "H");
        diccionario.put("..", "I");
        diccionario.put(".---", "J");
        diccionario.put("-.-", "K");
        diccionario.put(".-..", "L");
        diccionario.put("--", "M");
        diccionario.put("-.", "N");
        diccionario.put("---", "O");
        diccionario.put(".--.", "P");
        diccionario.put("--.-", "Q");
        diccionario.put(".-.", "R");
        diccionario.put("...", "S");
        diccionario.put("-", "T");
        diccionario.put("..-", "U");
        diccionario.put("...-", "V");
        diccionario.put(".--", "W");
        diccionario.put("-..-", "X");
        diccionario.put("-.--", "Y");
        diccionario.put("--..", "Z");
        diccionario.put("-----", "0");
        diccionario.put(".----", "1");
        diccionario.put("..---", "2");
        diccionario.put("...--", "3");
        diccionario.put("....-", "4");
        diccionario.put(".....", "5");
        diccionario.put("-....", "6");
        diccionario.put("--...", "7");
        diccionario.put("---..", "8");
        diccionario.put("----.", "9");
        diccionario.put(".-.-.-", ".");
        diccionario.put("--..--", ",");
        diccionario.put("..--..", "?");
        diccionario.put("-.-.--", "!");}
    public String traducir(String s){
        if (diccionario.get(s)==null){
            return "";
        }
        return diccionario.get(s);
    }
}
