package com.example.IntroSpring.service;

import com.example.IntroSpring.entity.DiccionarioMorse;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Service
public class TraductorMorse implements ItraduccionMorse{
    DiccionarioMorse diccionarioMorse = new DiccionarioMorse();
    @Override
    public String traducir(String s) {
        int contador=0;
        String frase="";
        String palabra="";
        //SEPARARDOR " "
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=' '){
                palabra+=s.charAt(i);
                contador=0;
                if (i==s.length()-1){
                    frase+=diccionarioMorse.traducir(palabra);
                }
            }else{
                if (contador==2){
                    frase+=" ";
                    contador=0;
                }
                contador++;
                frase+=diccionarioMorse.traducir(palabra);
                palabra="";}
        }
        System.out.println(frase);
        return frase;
    }

}
