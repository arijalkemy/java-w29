package com.bootcap.EjerDTOResponse.Entity_VIVOP2.service;

import com.bootcap.EjerDTOResponse.Entity_VIVOP2.model.Deporte;
import com.bootcap.EjerDTOResponse.Entity_VIVOP2.model.Persona;
import com.bootcap.EjerDTOResponse.Entity_VIVOP2.model.dto.Atleta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeportistasService {
    private static final List<Deporte> deportes = List.of(
            new Deporte("futbol", "amateur"),
            new Deporte("tenis", "profesional")
    );

    //trae todos los deportes
    public static List<Deporte> getDeportes() {
        return deportes;
    }
    //busca el deporte
    public static Deporte buscarDeporte(String nombre){
        return deportes.stream().filter(d-> d.getNombre().equals(nombre.toLowerCase())).findFirst().orElse(null);
    }

    private static final  List<Persona> personas = List.of(
            new Persona("Nicolas","Fiore",23, new Deporte("futbol","amateur")),
            new Persona("Aixa","Castillo",23, new Deporte("tenis","profesional"))
            );

    public static List<Atleta> buscarPersonasDeportista(){
        return personas.stream()
                .filter(p-> p.getDeporte() != null)
                .map(p-> new Atleta(p.getNombre(),p.getApellido(),p.getDeporte().getNombre()))
                .collect(Collectors.toList());
    }

}
