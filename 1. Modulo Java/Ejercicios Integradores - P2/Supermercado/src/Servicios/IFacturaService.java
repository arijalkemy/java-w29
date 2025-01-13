package Servicios;

import Modelos.Cliente;
import Modelos.Factura;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IFacturaService<T extends Factura> {
    T crearFactura(Cliente cliente, Map<String, Integer> codigosItems);
    Optional<T> buscarFacturaPorCodigo(String codigo);
}
