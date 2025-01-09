package Reservas;

public abstract class Reserva {

    protected String fecha;
    protected String hora;
    protected Double total;

    public Reserva(String fecha, String hora, Double total){
        this.fecha = fecha;
        this.hora= hora;
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    void verReserva(){
        System.out.println("Reserva");
    }

    public void aplicarDescuento(Double descuento) {
        this.total = this.total *(1-(descuento/100));
    }
    public void imprimirdetalles(){
        System.out.println("Fecha: "+fecha);
        System.out.println("Hora: "+hora);
        System.out.println("Total: "+total);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
