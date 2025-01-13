package Modelos;

import java.util.List;
import java.util.Map;

public class Factura {
    private String codigo;
    private String dniCliente;
    private Map<String, Integer> codigosItem;
    private Double total;

    public String getCodigo() {
        return codigo;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public Map<String, Integer> getCodigosItem() {
        return codigosItem;
    }

    public Double getTotal() {
        return total;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setCodigosItem(Map<String, Integer> ordenCompra) {
        this.codigosItem = ordenCompra;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Detalle factura:\n" +
                "codigo: " + codigo + '\n' +
                "dni cliente: " + dniCliente + '\n' +
                "items: " + codigosItem + '\n' +
                "total: " + total;
    }
}
