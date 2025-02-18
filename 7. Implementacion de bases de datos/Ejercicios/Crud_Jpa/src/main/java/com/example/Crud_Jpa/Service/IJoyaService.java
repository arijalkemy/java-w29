package com.example.Crud_Jpa.Service;

import com.example.Crud_Jpa.Model.Joya;

import java.util.List;

public interface IJoyaService {
    public List<Joya> getJoya();
    public Joya saveJoya(Joya joya);
    public void deleteJoya(Long id);
    public Joya findJoya (Long id);
}
