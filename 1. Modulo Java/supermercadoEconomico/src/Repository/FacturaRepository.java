package Repository;

import Models.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaRepository implements CRUD<Factura> {
    private List<Factura> facturas;

    public FacturaRepository() {
        this.facturas = new ArrayList<>();
    }

    @Override
    public void create(Factura factura) {
        if (!facturas.contains(factura)) {
            factura.setId(facturas.size() + 1);
            facturas.add(factura);
            System.out.println("Cliente adicionado com sucesso");
        }else{
            System.out.println("El cliente ya se encuentra registrado");
        }
    }

    @Override
    public void delete(Integer id) {
        this.facturas.removeIf(f -> f.getId() == id);
    }

    @Override
    public Factura get(Integer id) {
        return facturas.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Factura> getAll() {
        return this.facturas;
    }
}
