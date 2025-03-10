package org.example.ej_joyeria.service;

import org.example.ej_joyeria.model.Jewelry;
import org.example.ej_joyeria.repository.JewelryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryServiceImpl implements IJewelryService {

    private final JewelryRepository repository;

    public JewelryServiceImpl(JewelryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Jewelry> getJewelry() {
        return repository.findAll()
                .stream()
                .filter(jewelry -> jewelry.getVentaONo().equals(true))
                .toList();
    }

    @Override
    public void addJewelry(Jewelry jewelry) {
        repository.save(jewelry);
    }

    @Override
    public void deleteJewelry(Long id) {
        Optional<Jewelry> jewelry = repository.findById(id);
        if (jewelry.isEmpty()) {
            throw new IllegalArgumentException("ID no encontrado");
        }
        jewelry.get().setVentaONo(false);
        repository.save(jewelry.get());
    }

    @Override
    public void updateJewelry(Long id,Jewelry jw) {
        Optional<Jewelry> jewelry = repository.findById(id);
        if (jewelry.isEmpty()) {
            throw new IllegalArgumentException("ID no encontrado");
        }
        jw.setId(jewelry.get().getId());
        repository.save(jw);

    }
}
