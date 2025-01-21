package com.melibootcamp.edadPersona;

import com.melibootcamp.edadPersona.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public  class Repository {
    private static List<Persona> personas= new ArrayList<>();
    public static void addPersona(Persona persona){
        personas.add(persona);
    }
    public static Persona buscarPersona(String id){
        for (Persona persona: personas){
            if(persona.getId().equals(id)){
                return persona;
            }
        }
        return null;
    }
}
