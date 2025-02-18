package com.example.Crud_Jpa.Service;

import com.example.Crud_Jpa.Model.Joya;
import com.example.Crud_Jpa.Repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {
    @Autowired
    JoyaRepository repository;
    @Override
    public List<Joya> getJoya() {
        List<Joya> joyas = repository.findAll();
        return joyas;
    }

    @Override
    public Joya saveJoya(Joya joya) {
       Joya joyacreada = repository.save(joya);
       return joyacreada;
    }

    @Override
    public void deleteJoya(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Joya findJoya(Long id) {
        Joya joya = repository.findById(id).orElse(null);
        return joya;
    }
}
