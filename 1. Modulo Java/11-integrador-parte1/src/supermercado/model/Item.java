package supermercado.model;

public class Item {
    private Long codigo;
    private String descripcion;
    private Integer cantidad;
    private Double costoUnitario;

    public Item() {
    }

    public Item(Long codigo, Double costoUnitario, Integer cantidad, String descripcion) {
        this.codigo = codigo;
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
