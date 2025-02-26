package com.pruebaa.pruebademo.service;

import com.pruebaa.pruebademo.model.ObraLiteraria;
import com.pruebaa.pruebademo.repository.IObrasRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObrasServiceImpl implements IObrasService{

    private final IObrasRepository obrasRepository;

    public ObrasServiceImpl(IObrasRepository obrasRepository){
        this.obrasRepository = obrasRepository;
    }

    @Override
    public ObraLiteraria saveObra(ObraLiteraria obraLiteraria) {
        if (obrasRepository.existsById(obraLiteraria.getId())) {
            throw new IllegalArgumentException("Ya existe una obra con el mismo id");
        }
        return obrasRepository.save(obraLiteraria);
    }

    @Override
    public List<ObraLiteraria> findAll() {
        return obrasRepository.findAll();
    }

    @Override
    public void deleteObra(String id) {
        obrasRepository.deleteById(id);
    }

    @Override
    public ObraLiteraria findById(String id) {
        return obrasRepository.findById(id).orElse(null);
    }

    @Override
    public ObraLiteraria findByIdAndAuthor(String id, String autor) {
        return obrasRepository.findByIdAndAuthor(id, autor).orElse(null);
    }

}
