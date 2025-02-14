package com.example.jewelry.service;

import com.example.jewelry.exception.IllegalActionException;
import com.example.jewelry.exception.NotFoundException;
import com.example.jewelry.model.Jewelry;
import com.example.jewelry.repository.JewelryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JewelryServiceImpl implements JewelryService {

    private final JewelryRepository repository;

    @Override
    public List<Jewelry> getJewelry() {
        return repository.findAll();
    }

    @Override
    public void updateJewelry(Long id, Jewelry jewelry) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Jewelry not found");
        }
        jewelry.setId(id);
        repository.save(jewelry);
    }

    @Override
    public void saveJewelry(Jewelry jewelry) {
        if (!jewelry.getVentaONo()) {
            throw new IllegalActionException("Jewelry not for sale");
        }
        repository.save(jewelry);
    }

    @Override
    public void deleteJewelry(Long id) {
        Jewelry jewelry = findJewelry(id);
        if (jewelry.getVentaONo()) {
            throw new IllegalActionException("Jewelry for sale");
        }
        repository.deleteById(id);
    }

    @Override
    public Jewelry findJewelry(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Jewelry not found"));
    }
}
