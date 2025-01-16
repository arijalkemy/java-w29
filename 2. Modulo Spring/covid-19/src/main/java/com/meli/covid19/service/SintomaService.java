package com.meli.covid19.service;

import com.meli.covid19.model.SintomaModel;
import com.meli.covid19.repository.SintomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SintomaService {

    public List<SintomaModel> getSintomas(){
        SintomaRepository sintomaRepository = new SintomaRepository();
        return sintomaRepository.sintomasList;
    }

    public SintomaModel getSintomaById(Integer codigo){
        SintomaRepository sintomaRepository = new SintomaRepository();
        SintomaModel sintoma = sintomaRepository.sintomasList.stream().filter(sintomaModel -> sintomaModel.codigo.equals(codigo)).collect(Collectors.toList()).get(0);
        return sintoma;
    }

    public SintomaModel getSintomaByName(String name){
        SintomaRepository sintomaRepository = new SintomaRepository();
        SintomaModel sintoma = sintomaRepository.sintomasList.stream().filter(sintomaModel -> sintomaModel.nombre.equals(name)).collect(Collectors.toList()).get(0);
        return sintoma;
    }
}
