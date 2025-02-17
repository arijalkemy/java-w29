package exercise.claves_compuestas.service;

import exercise.claves_compuestas.entity.Compra;
import exercise.claves_compuestas.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public void crearComprasEjemplo() {
        List<Compra> compras = new ArrayList<>();

        // Compra 1
        Compra compra1 = new Compra();
        compra1.setClienteId(1L);
        compra1.setFecha(LocalDateTime.now());
        compra1.setNumeroOrden("ORD-001");
        compra1.setMontoTotal(new BigDecimal("1500.00"));
        compra1.setEstado("COMPLETADA");
        compras.add(compra1);

        // Compra 2
        Compra compra2 = new Compra();
        compra2.setClienteId(1L);
        compra2.setFecha(LocalDateTime.now().plusHours(1));
        compra2.setNumeroOrden("ORD-002");
        compra2.setMontoTotal(new BigDecimal("2300.50"));
        compra2.setEstado("PENDIENTE");
        compras.add(compra2);

        // Compra 3
        Compra compra3 = new Compra();
        compra3.setClienteId(2L);
        compra3.setFecha(LocalDateTime.now());
        compra3.setNumeroOrden("ORD-003");
        compra3.setMontoTotal(new BigDecimal("750.25"));
        compra3.setEstado("COMPLETADA");
        compras.add(compra3);

        // Compra 4
        Compra compra4 = new Compra();
        compra4.setClienteId(3L);
        compra4.setFecha(LocalDateTime.now().minusDays(1));
        compra4.setNumeroOrden("ORD-004");
        compra4.setMontoTotal(new BigDecimal("3200.00"));
        compra4.setEstado("COMPLETADA");
        compras.add(compra4);

        try {
            compraRepository.saveAll(compras);
            System.out.println("Compra guardadas exitosamente");
        } catch (Exception e) {
            System.err.println("Error al guardar las compras: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Compra> obtenerTodasLasCompra() {
        return compraRepository.findAll();
    }

}
