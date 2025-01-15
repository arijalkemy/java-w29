package com.mdaneri.concesionariap2vivo2.service;

import com.mdaneri.concesionariap2vivo2.dto.CarDTO;
import com.mdaneri.concesionariap2vivo2.dto.request.RequestCarDTO;
import com.mdaneri.concesionariap2vivo2.dto.response.ResponseCarDTO;
import com.mdaneri.concesionariap2vivo2.entity.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IConcessionaireService {

    List<ResponseCarDTO> findAll();
    Optional<ResponseCarDTO> findById(Integer id);
    Optional<ResponseCarDTO> save(RequestCarDTO car);
    List<ResponseCarDTO> findByPrice(Integer from, Integer to);
    List<ResponseCarDTO> findByDate(LocalDate from, LocalDate to);


}
