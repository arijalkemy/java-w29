import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;


    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        calcularTotal();
    }

    private void calcularTotal() {
        total = items.stream().mapToDouble(Item::getTotalCosto).sum();
    }


    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Factura para " + cliente.toString() + ", total=" + total;
    }
}