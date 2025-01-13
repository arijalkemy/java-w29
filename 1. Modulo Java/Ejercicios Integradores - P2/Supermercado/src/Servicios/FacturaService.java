package Servicios;

import Modelos.Cliente;
import Modelos.Factura;
import Modelos.Item;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class FacturaService implements IFacturaService<Factura> {

    private List<Factura> facturas;
    private IClienteService clienteService;
    private IItemService itemService;

    public FacturaService(List<Factura> facturas, IClienteService clienteService, IItemService itemService) {
        this.facturas = facturas;
        this.clienteService = clienteService;
        this.itemService = itemService;
    }

    @Override
    public Factura crearFactura(Cliente cliente, Map<String, Integer> ordenCompra) {

        Factura factura = new Factura();

        Optional<Cliente> optionalCliente = clienteService.encontrarClientePordni(cliente.getDni());

        if (optionalCliente.isEmpty()) {
            System.out.println("Cliente con dni " + cliente.getDni() + " no encontrado. Dando de alta...");
            clienteService.crearCliente(cliente);
            System.out.println("Cliente creado.");
        }


        factura.setDniCliente(cliente.getDni());
        factura.setCodigo(UUID.randomUUID().toString());
        factura.setCodigosItem(ordenCompra);

        ordenCompra.keySet().forEach(codigo -> {
            Optional<Item> optionalItem = itemService.obtenerItemPorId(codigo);
            if (optionalItem.isPresent()) {
                Double total = optionalItem.get().getPrecio() * ordenCompra.get(codigo);
                factura.setTotal(total);
            }
        });

        facturas.add(factura);

        return factura;

    }

    @Override
    public Optional<Factura> buscarFacturaPorCodigo(String codigo) {
        return Optional.empty();
    }
}
