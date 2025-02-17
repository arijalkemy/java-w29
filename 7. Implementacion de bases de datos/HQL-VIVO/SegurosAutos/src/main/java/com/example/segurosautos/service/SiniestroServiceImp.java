package com.example.segurosautos.service;

import com.example.segurosautos.repository.ISiniestroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SiniestroServiceImp implements ISiniestroService{
    private final ISiniestroRepository siniestroRepository;
}
