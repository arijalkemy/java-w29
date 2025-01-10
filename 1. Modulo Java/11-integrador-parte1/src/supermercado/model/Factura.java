package supermercado.model;

import java.util.List;

public class Factura {
    private Long codigoFactura;
    private Cliente cliente;
    private List<Item> items;
    private Double total;

    public Factura() {
    }

    public Factura(Long codigoFactura, Cliente cliente, List<Item> items, Double total) {
        this.codigoFactura = codigoFactura;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public Long getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Long codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigoFactura=" + codigoFactura +
                ", cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
