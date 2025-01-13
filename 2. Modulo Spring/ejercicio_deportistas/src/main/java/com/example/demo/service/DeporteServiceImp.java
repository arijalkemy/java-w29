package com.example.demo.service;

import com.example.demo.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteServiceImp implements DeporteService {

    private final  List<Deporte> deporteList = new ArrayList<>();
    @Override
    public List<Deporte> verDeportes() {
        return deporteList;
    }

    @Override
    public Deporte buscarPorNombre(String nombre) {
        for (Deporte deporte : deporteList) {
            if (deporte.getNombre().equals(nombre)) {
                return deporte;
            }
        }
        return null;
    }

    @Override
    public void saveDeporte(Deporte deporte) {
        deporteList.add(deporte);
    }
}
