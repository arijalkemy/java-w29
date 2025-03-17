package com.example.obrasliterarias.service;

import com.example.obrasliterarias.model.ObraLiteraria;
import com.example.obrasliterarias.repository.IObrasLiterariasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObrasLiterariasService implements IObrasLiterariasService {

    private final IObrasLiterariasRepository obrasLiterariasRepository;

    @Override
    public List<ObraLiteraria> getObrasByAutor(String autor) {
        return (List<ObraLiteraria>) obrasLiterariasRepository.findByAutor(autor);
    }

    @Override
    public List<ObraLiteraria> getObrasByTitleContaining(String keyword) {
        return (List<ObraLiteraria>) obrasLiterariasRepository.findByTitleContaining(keyword);
    }

    @Override
    public List<ObraLiteraria> getTop5ObrasByPages() {
        return (List<ObraLiteraria>) obrasLiterariasRepository.findTop5ByOrderByPagesDesc();
    }

    @Override
    public List<ObraLiteraria> getObrasPublishedBeforeYear(Integer year) {
        return (List<ObraLiteraria>) obrasLiterariasRepository.findByYearLessThan(year);
    }

    @Override
    public List<ObraLiteraria> getObrasByEditorial(String editorial) {
        return (List<ObraLiteraria>) obrasLiterariasRepository.findByEditorial(editorial);
    }
}
