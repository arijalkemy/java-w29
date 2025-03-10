package com.meli.laperlaejercicio.service;

import com.meli.laperlaejercicio.entity.Jewelry;
import com.meli.laperlaejercicio.repository.IJewelryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryService implements IJewelryService {
    private final IJewelryRepository jewelryRepository;

    public JewelryService(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }

    @Override
    public String saveJewelry(Jewelry jewelry) {
        jewelryRepository.save(jewelry);

        return "Joya guardada correctamente";
    }

    @Override
    public List<Jewelry> findJewelrys() {
        return jewelryRepository.findAll();
    }

    @Override
    public Optional<Jewelry> findJewelry(Long id) {
        return Optional.ofNullable(jewelryRepository.findById(id).orElse(null));
    }

    @Override
    public String deleteJewelry(Long id) {
        Optional<Jewelry> jewelryOriginal = this.findJewelry(id);
        jewelryOriginal.get().setVentaONo(false);
        this.saveJewelry(jewelryOriginal.get());

        return "Joya dada de baja para la venta correctamente";
    }

    @Override
    public String editJewelry(Long id_modificar, Jewelry jewelry_modif) {

        Optional<Jewelry> joyaOriginal = this.findJewelry(id_modificar);

        joyaOriginal.get().setNombre(jewelry_modif.getNombre());
        joyaOriginal.get().setMaterial(jewelry_modif.getMaterial());
        joyaOriginal.get().setPeso(jewelry_modif.getPeso());
        joyaOriginal.get().setParticularidad(jewelry_modif.getParticularidad());
        joyaOriginal.get().setPosee_piedra(jewelry_modif.isPosee_piedra());
        joyaOriginal.get().setVentaONo(jewelry_modif.isVentaONo());

        this.saveJewelry(joyaOriginal.get());
        return "Modificaciones guardadas correctamente";
    }
}
