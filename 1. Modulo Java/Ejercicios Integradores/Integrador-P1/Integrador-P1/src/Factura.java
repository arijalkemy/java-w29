import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private Double totalCompra;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        // sacarTotal() pasa el total de la compra a la factura
        this.totalCompra = sacarTotal();
    }

    //recorro la lista de items y saco el total de la compra
    public Double sacarTotal(){
        double precio = 0.0;
        for (Item i: items){
            precio += i.getCantidadComprada() * i.getCostoUnitario();
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Factura: " + "cliente: " + getCliente() + ", items: " + getItems() + ", totalCompra = " + getTotalCompra();
    }
}
