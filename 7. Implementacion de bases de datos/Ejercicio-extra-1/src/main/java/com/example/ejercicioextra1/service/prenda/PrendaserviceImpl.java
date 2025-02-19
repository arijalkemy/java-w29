package com.example.ejercicioextra1.service.prenda;

import com.example.ejercicioextra1.dto.reponse.PostPrendasResponseDto;
import com.example.ejercicioextra1.dto.request.PostPrendasRequestDto;
import com.example.ejercicioextra1.entity.jpa.Prenda;
import com.example.ejercicioextra1.repository.jpa.IPrendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PrendaserviceImpl implements IPrendaService {
    private final IPrendaRepository prendaRepository;

    @Override
    public PostPrendasResponseDto save(PostPrendasRequestDto postPrendasRequestDto) {
        Prenda prenda = Prenda.builder()
                .nombre(postPrendasRequestDto.getNombre())
                .tipo(postPrendasRequestDto.getTipo())
                .marca(postPrendasRequestDto.getMarca())
                .color(postPrendasRequestDto.getColor())
                .talle(postPrendasRequestDto.getTalle())
                .cantidad(postPrendasRequestDto.getCantidad())
                .precioVenta(postPrendasRequestDto.getPrecioVenta())
                .build();

        Prenda newPrenda = prendaRepository.save(prenda);

        return PostPrendasResponseDto.builder()
                .id(newPrenda.getId())
                .nombre(newPrenda.getNombre())
                .tipo(newPrenda.getTipo())
                .marca(newPrenda.getMarca())
                .color(newPrenda.getColor())
                .talle(newPrenda.getTalle())
                .cantidad(newPrenda.getCantidad())
                .precioVenta(newPrenda.getPrecioVenta())
                .build();
    }

    @Override
    public List<PostPrendasResponseDto> findAll(String talle, String name) {
        List<Prenda> prendas;

        if (talle.isEmpty() && name.isEmpty()) {
            prendas = prendaRepository.findAll();
        } else if (!name.isEmpty()) {
            prendas = prendaRepository.findAllByNombre(name);
        } else {
            prendas = prendaRepository.findAllByTalle(talle);
        }

        return prendas.stream().map(prenda -> PostPrendasResponseDto.builder()
                .id(prenda.getId())
                .nombre(prenda.getNombre())
                .tipo(prenda.getTipo())
                .marca(prenda.getMarca())
                .color(prenda.getColor())
                .talle(prenda.getTalle())
                .cantidad(prenda.getCantidad())
                .precioVenta(prenda.getPrecioVenta())
                .build()).toList();
    }


    @Override
    public PostPrendasResponseDto findById(Long id) {
        Prenda prenda = prendaRepository.findById(id).orElseThrow(RuntimeException::new);
        return PostPrendasResponseDto.builder()
                .id(prenda.getId())
                .nombre(prenda.getNombre())
                .tipo(prenda.getTipo())
                .marca(prenda.getMarca())
                .color(prenda.getColor())
                .talle(prenda.getTalle())
                .cantidad(prenda.getCantidad())
                .precioVenta(prenda.getPrecioVenta())
                .build();
    }

    @Override
    public void modifyById(Long id, PostPrendasRequestDto postPrendasRequestDto) {

        Prenda prenda = prendaRepository.findById(id).orElseThrow(RuntimeException::new);
        Prenda prendaActualizada = Prenda.builder()
                .nombre(postPrendasRequestDto.getNombre())
                .tipo(postPrendasRequestDto.getTipo())
                .marca(postPrendasRequestDto.getMarca())
                .color(postPrendasRequestDto.getColor())
                .talle(postPrendasRequestDto.getTalle())
                .cantidad(postPrendasRequestDto.getCantidad())
                .precioVenta(postPrendasRequestDto.getPrecioVenta())
                .build();

        prendaActualizada.setId(prenda.getId());
        prendaRepository.save(prendaActualizada);

    }


    @Override
    public void deleteById(Long id) {
        prendaRepository.findById(id).orElseThrow(RuntimeException::new);
        prendaRepository.deleteById(id);
    }
}
