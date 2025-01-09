package org.bootcamp.reservas;

public class Comida extends Reserva{
    private String restaurante;
    private String ciudad;
    private String tipoComida;
    private String ubicacion;

    public Comida(String restaurante, String ciudad, String fecha, String hora, String tipoComida,String ubicacion,Double total){
        super(fecha,hora, total);
        this.restaurante = restaurante;
        this.ciudad = ciudad;
        this.tipoComida = tipoComida;
        this.ubicacion = ubicacion;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    @Override
    public void imprimirdetalles(){
        System.out.println("Restaurante: "+restaurante);
        System.out.println("Ciudad: "+ciudad);
        System.out.println("Tipo de comida: "+tipoComida);
        System.out.println("Ubicacion: "+ubicacion);
        System.out.println("Fecha: "+fecha);
        System.out.println("Hora: "+hora);
        System.out.println("Total: "+total);
    }

    @Override
    public String toString() {
        return "Comida{" +
                "restaurante='" + restaurante + '\n' +
                ", ciudad='" + ciudad + '\n' +
                ", tipoComida='" + tipoComida + '\n' +
                ", ubicacion='" + ubicacion + '\n' +
                ", fecha='" + fecha + '\n' +
                ", hora='" + hora + '\n' +
                ", total=" + total +
                "\n\n";
    }
}
