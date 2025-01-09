package org.bootcamp.reservas;

public class Hotel extends Reserva{
    private String Hotel;
    private String ciudad;
    private String fechaFin;
    private String horaFin;
    private String tipoHabitacion;

    public Hotel(String Hotel, String ciudad, String fechaInicio,String hora, String fechaFin,String horaFin, String tipoHabitacion, Double total){
        super(fechaInicio,hora, total);
        this.Hotel = Hotel;
        this.ciudad = ciudad;
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getHotel() {
        return Hotel;
    }

    public void setHotel(String hotel) {
        Hotel = hotel;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    @Override
    public void imprimirdetalles(){
        System.out.println("Hotel: "+Hotel);
        System.out.println("Ciudad: "+ciudad);
        System.out.println("Fecha Inicio: "+fecha);
        System.out.println("Hora Inicio: "+hora);
        System.out.println("Fecha Fin: "+fechaFin);
        System.out.println("Hora Fin: "+horaFin);
        System.out.println("Tipo de Habitacion: "+tipoHabitacion);
        System.out.println("Total: "+total);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "Hotel='" + Hotel + '\n' +
                ", ciudad='" + ciudad + '\n' +
                ", fechaFin='" + fechaFin + '\n' +
                ", horaFin='" + horaFin + '\n' +
                ", tipoHabitacion='" + tipoHabitacion + '\n' +
                ", fecha='" + fecha + '\n' +
                ", hora='" + hora + '\n' +
                ", total=" + total +
                "\n\n";
    }
}
