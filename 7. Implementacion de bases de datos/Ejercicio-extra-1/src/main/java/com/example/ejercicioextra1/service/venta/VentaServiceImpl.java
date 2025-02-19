package com.example.ejercicioextra1.service.venta;

import com.example.ejercicioextra1.dto.reponse.GetPrendasForVentaResponseDto;
import com.example.ejercicioextra1.dto.reponse.PostPrendasResponseDto;
import com.example.ejercicioextra1.dto.reponse.PostVentaResponseDto;
import com.example.ejercicioextra1.dto.request.PostVentaRequestDto;
import com.example.ejercicioextra1.entity.Prenda;
import com.example.ejercicioextra1.entity.Venta;
import com.example.ejercicioextra1.repository.IPrendaRepository;
import com.example.ejercicioextra1.repository.IVentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VentaServiceImpl implements IVentaService {

    private final IVentaRepository ventaRepository;
    private final IPrendaRepository prendaRepository;

    @Override
    public PostVentaResponseDto save(PostVentaRequestDto postVentaRequestDto) {
        Venta venta = mapToVenta(postVentaRequestDto);
        return mapToPostVentaResponseDto(ventaRepository.save(venta));
    }

    @Override
    public List<PostVentaResponseDto> findAll(String fecha) {
        LocalDate fechaFormateada = (fecha.isEmpty()) ? null : LocalDate.parse(fecha);
        List<Venta> ventas = (fecha.isEmpty()) ? ventaRepository.findAll() : ventaRepository.findAllByFecha(fechaFormateada);
        return ventas.stream().map(this::mapToPostVentaResponseDto).toList();
    }

    @Override
    public PostVentaResponseDto findById(Long id) {
        Venta venta = ventaRepository.findById(id).orElseThrow(RuntimeException::new);
        return mapToPostVentaResponseDto(venta);
    }

    @Override
    public void modifyById(Long id, PostVentaRequestDto postVentaRequestDto) {
        ventaRepository.findById(id).orElseThrow(RuntimeException::new);

        Venta udateVenta = mapToVenta(postVentaRequestDto);

        prendaRepository.findAllByVentaId(id)
                .forEach(prenda -> prenda.setVenta(null));

        udateVenta.setId(id);
        ventaRepository.save(udateVenta);
    }

    @Override
    public void deleteById(Long id) {
        ventaRepository.findById(id).orElseThrow(RuntimeException::new);
        ventaRepository.deleteById(id);
    }

    @Override
    public GetPrendasForVentaResponseDto getPrendasForVenta(Long id) {
        Venta venta = ventaRepository.findById(id).orElseThrow(RuntimeException::new);
        List<Prenda> prendas = venta.getPrendas();



        return GetPrendasForVentaResponseDto.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .total(venta.getTotal())
                .prendas(prendas.stream().map(this::mapToPostPrendasResponseDto).toList())
                .build();
    }

    private PostVentaResponseDto mapToPostVentaResponseDto(Venta venta) {
        return PostVentaResponseDto.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .total(venta.getTotal())
                .medioPago(venta.getMedioPago())
                .prendas(venta.getPrendas().stream().map(this::mapToPostPrendasResponseDto).toList())
                .build();
    }

    private Venta mapToVenta(PostVentaRequestDto postVentaRequestDto) {
        List<Prenda> prendas = postVentaRequestDto.getPrendasIds().stream()
                .map(prenda -> prendaRepository.findById(prenda).orElseThrow(RuntimeException::new))
                .toList();

        Venta venta = Venta.builder()
                .fecha(postVentaRequestDto.getFecha())
                .total(postVentaRequestDto.getTotal())
                .medioPago(postVentaRequestDto.getMedioPago())
                .prendas(prendas)
                .build();

        prendas.forEach(prenda -> prenda.setVenta(venta));

        return venta;
    }

    private PostPrendasResponseDto mapToPostPrendasResponseDto(Prenda prenda) {
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
}
