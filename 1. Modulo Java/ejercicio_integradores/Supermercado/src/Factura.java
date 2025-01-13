import java.util.List;

public class Factura {
    Cliente cliente;
    List<Item> listaCompras;
    Double total;

    public Factura(Cliente cliente, List<Item> listaCompras) {
        this.cliente = cliente;
        this.listaCompras = listaCompras;
        this.total = calculaTotal();
    }

    private Double calculaTotal(){
        Double total = 0.0;
        for (Item item : this.listaCompras) {
            total += item.costo;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaCompras=" + listaCompras +
                ", total=" + total +
                '}';
    }
}
