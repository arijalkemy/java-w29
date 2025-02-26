package com.pruebaa.pruebademo.service;

import com.pruebaa.pruebademo.model.ObraLiteraria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IObrasService {
    ObraLiteraria saveObra(ObraLiteraria obraLiteraria);
    List<ObraLiteraria> findAll();
    void deleteObra(String id);
    ObraLiteraria findById(String id);
    ObraLiteraria findByIdAndAuthor(String id, String autor);
}
