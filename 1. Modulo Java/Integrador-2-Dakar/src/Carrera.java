import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<Vehiculo>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        agregarVehiculo(auto);
    }

    private void agregarVehiculo(Vehiculo vehiculo) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            this.vehiculos.add(vehiculo);
        }else{
            System.out.println("No hay Cupo en la Carrera, Limite: " + this.cantidadDeVehiculosPermitidos);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        agregarVehiculo(moto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo v = this.buscarVehiculoPorPatente(patente);
        if (v != null) {
            this.eliminarVehiculo(v);
        }

    }

    public Vehiculo getGanadador(){
        Vehiculo ganador = null;
        double maxValor = -Double.MAX_VALUE;
        for (Vehiculo v : this.vehiculos) {
            double valor = v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
            if (valor > maxValor) {
                maxValor = valor;
                ganador = v;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente){
        Auto auto = (Auto) this.buscarVehiculoPorPatente(patente);
        if (auto != null) {
            socorristaAuto.socorrer(auto);
        }

    }

    public void socorrerMoto(String patente){
        Moto moto = (Moto) this.buscarVehiculoPorPatente(patente);
        if (moto != null) {
            socorristaMoto.socorrer(moto);
        }

    }

    private Vehiculo buscarVehiculoPorPatente(String patente) {
        Vehiculo v = (Vehiculo) vehiculos.stream()
                .filter(ve -> ve.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
        return v;
    }
}