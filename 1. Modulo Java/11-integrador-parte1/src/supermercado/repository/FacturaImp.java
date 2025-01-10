package supermercado.repository;

import supermercado.model.Cliente;
import supermercado.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura> {
    List<Factura> facturas = new ArrayList<>();

    @Override
    public void guardar(Factura obj) {
        facturas.add(obj);
    }

    @Override
    public void mostrarPorPantalla() {
        facturas.forEach(System.out::println);
    }

    @Override
    public Optional<Factura> buscar(Long id) {
        Factura f = (Factura) facturas.stream()
                .filter(fac -> fac.getCodigoFactura().equals(id))
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(f);
    }

    @Override
    public void eliminar(Long id) {
        Optional<Factura> f = this.buscar(id);

        if(f.isEmpty()){
            System.out.println("No existe factura");

        } else {
            facturas.remove(f.get());
            System.out.println("Se ha eliminado factura");
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return facturas;
    }
}
