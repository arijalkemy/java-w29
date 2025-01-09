package org.bootcamp.reservas;

public class Vuelo extends Reserva{
    private String aerolinea;
    private String origen;

    private String fechaVuelta;
    private String horaVuelta;
    private String destino;
    private String clase;

    public Vuelo(String aerolinea, String origen, String destino,
                 String fecha, String hora,String fechaVuelta, String horaVuelta, String clase, Double total){
        super(fecha,hora, total);
        this.fechaVuelta = fechaVuelta;
        this.horaVuelta = horaVuelta;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.clase = clase;

    }

    public Vuelo(String aerolinea, String origen, String destino, String fecha, String hora, String clase, Double total){
        super(fecha,hora, total);
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.clase = clase;
    }


    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getFechaVuelta() {
        return fechaVuelta;
    }

    public void setFechaVuelta(String fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }

    public String getHoraVuelta() {
        return horaVuelta;
    }

    public void setHoraVuelta(String horaVuelta) {
        this.horaVuelta = horaVuelta;
    }
    @Override
    public void imprimirdetalles(){
        System.out.println("Aerolinea: "+aerolinea);
        System.out.println("Origen: "+origen);
        System.out.println("Destino: "+destino);
        System.out.println("Fecha: "+fecha);
        System.out.println("Hora: "+hora);
        System.out.println("Clase: "+clase);
        if(fechaVuelta != null){
            System.out.println("Fecha de vuelta: "+fechaVuelta);
            System.out.println("Hora de vuelta: "+horaVuelta);
        }
        System.out.println("Total: "+total);
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "aerolinea='" + aerolinea + '\n' +
                ", origen='" + origen + '\n' +
                ", fechaVuelta='" + fechaVuelta + '\n' +
                ", horaVuelta='" + horaVuelta + '\n' +
                ", destino='" + destino + '\n' +
                ", clase='" + clase + '\n' +
                ", fecha='" + fecha + '\n' +
                ", hora='" + hora + '\n' +
                ", total=" + total +
                "}\n\n";
    }
}
