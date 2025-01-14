package org.bootcamp.dtoyresponseentityp2.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.bootcamp.dtoyresponseentityp2.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeporteService {

    private final List<Deporte> deportes = new ArrayList<>();

    @PostConstruct
    private void inicializarListaDeportes(){
        deportes.add(new Deporte("Futbol", "1"));
        deportes.add(new Deporte("Basketball", "2"));
        deportes.add(new Deporte("Billar", "3"));
        deportes.add(new Deporte("Ping pong", "4"));
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public Optional<Deporte> getDeporteByName(String name) {
        return deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst();
    }
}
