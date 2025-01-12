public class Item {
    private Long codigo;
    private String nombre;
    private  Integer cantidadComprada;
    private Double costoUnitario;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Item(Long codigo, String nombre, Integer cantidadComprada, Double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "(Item: " + "codigo = " + getCodigo() + ", nombre = '" + getNombre() + '\''
                + ", cantidadComprada = " + getCantidadComprada() + ", costoUnitario = " + getCostoUnitario() + ")";
    }
}
