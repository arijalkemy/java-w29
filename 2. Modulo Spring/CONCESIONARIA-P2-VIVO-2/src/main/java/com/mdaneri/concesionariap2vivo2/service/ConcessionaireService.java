package com.mdaneri.concesionariap2vivo2.service;

import com.mdaneri.concesionariap2vivo2.dto.CarDTO;
import com.mdaneri.concesionariap2vivo2.dto.request.RequestCarDTO;
import com.mdaneri.concesionariap2vivo2.dto.response.ResponseCarDTO;
import com.mdaneri.concesionariap2vivo2.entity.Car;
import com.mdaneri.concesionariap2vivo2.mapper.CarMapper;
import com.mdaneri.concesionariap2vivo2.repository.IConcessionaireRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ConcessionaireService implements IConcessionaireService {

    IConcessionaireRepository cr;

    public ConcessionaireService(IConcessionaireRepository cr) {
        this.cr = cr;
    }

    @Override
    public List<ResponseCarDTO> findAll() {
        return cr.findAll().stream().map(CarMapper::toDTO).toList();
    }

    @Override
    public Optional<ResponseCarDTO> findById(Integer id) {
        if (id < 0)
            throw new IllegalArgumentException("Id must be positive");
        return cr.findById(id).map(CarMapper::toDTO);
    }

    @Override
    public Optional<ResponseCarDTO> save(RequestCarDTO car) {
        Optional<Car> optionalCar = cr.save(CarMapper.fromDTO(car));
        return Optional.of(CarMapper.toDTO(optionalCar.get()));
    }

    @Override
    public List<ResponseCarDTO> findByPrice(Integer from, Integer to) {
        return cr.findByPrice(from, to).stream().map(CarMapper::toDTO).toList();
    }

    @Override
    public List<ResponseCarDTO> findByDate(LocalDate from, LocalDate to) {
        return cr.findByDate(from, to).stream().map(CarMapper::toDTO).toList();
    }

}
