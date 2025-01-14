package parte1;

public class Factura {
    public Cliente cliente;
    public Item[] items;
    public Integer precioTotal;

    public Factura(Cliente cliente, Item[] items) {
        this.cliente = cliente;
        this.items = items;
        this.precioTotal = calculaTotal(items);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer calculaTotal(Item[] items) {
        Integer total = 0;
        for (Item item : items) {
            total += item.getPrecio();
        }
        return total;
    }
}
