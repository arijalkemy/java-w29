package Reservas;

public class Transporte extends Reserva{
    private String origen;
    private String destino;
    private String tipo;
    private String empresa;

    public Transporte(String origen, String destino, String fecha ,String hora , String tipo, String empresa,Double total){
        super(fecha,hora, total);
        this.origen = origen;
        this.destino = destino;
        this.tipo = tipo;
        this.empresa = empresa;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    @Override
    public void imprimirdetalles(){
        System.out.println("Origen: "+origen);
        System.out.println("Destino: "+destino);
        System.out.println("Fecha: "+fecha);
        System.out.println("Hora: "+hora);
        System.out.println("Tipo: "+tipo);
        System.out.println("Empresa: "+empresa);
        System.out.println("Total: "+total);
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "origen='" + origen + '\n' +
                ", destino='" + destino + '\n' +
                ", tipo='" + tipo + '\n' +
                ", empresa='" + empresa + '\n' +
                ", fecha='" + fecha + '\n' +
                ", hora='" + hora + '\n' +
                ", total=" + total +
                "\n\n";
    }
}
