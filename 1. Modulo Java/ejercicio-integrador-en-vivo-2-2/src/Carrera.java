import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto moto;

    public Carrera(double distancia, String nombre, double premioEnDolares, int cantidadVehiculosPermitidos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.nombre = nombre;
        this.premioEnDolares = premioEnDolares;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion,double anguloDeGiro, String patente){
        if(listaVehiculos.size() < cantidadVehiculosPermitidos){
            Auto auto1 = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            listaVehiculos.add(auto1);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion,double anguloDeGiro, String patente){
        if(listaVehiculos.size() < cantidadVehiculosPermitidos) {
            Moto moto1 = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            listaVehiculos.add(moto1);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(listaVehiculos.contains(vehiculo)){
            listaVehiculos.remove(vehiculo);
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){
//       for(Vehiculo vehiculo : listaVehiculos){
//            if(vehiculo.getPatente().equals(unaPatente)){
//                listaVehiculos.remove(vehiculo);
//            }
//        }
        listaVehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
       // listaVehiculos.stream().filter(v -> !v.getPatente().equals(unaPatente));
    };

    public void ganadorCarrera(){
        double maxValor = Double.MIN_VALUE;
        String patente = "";

        for(Vehiculo vehiculo : listaVehiculos){
            double formula = (vehiculo.getVelocidad() * vehiculo.getAceleracion()/2)
                    /(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getCantRuedas()* 100));

            if(maxValor < formula){
                maxValor = formula;
                patente = vehiculo.getPatente();
            }
        }
        System.out.println("El ganador es: " + patente);
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public SocorristaMoto getMoto() {
        return moto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public void setMoto(SocorristaMoto moto) {
        this.moto = moto;
    }

    public void socorrerAuto(String patente){
//        for(Vehiculo vehiculo : listaVehiculos){
//            if(vehiculo.getPatente().equals(patente)){
//                socorristaAuto.socorrer(vehiculo);
//            }
//        }

        listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .forEach(socorristaAuto::socorrer);

//        // Usamos stream para buscar el primer vehículo que sea un Auto y tenga la patente indicada
//        Vehiculo vehiculo = listaDeVehiculos.stream()
//                .filter(v -> v instanceof Auto)  // Filtramos solo los vehículos de tipo Auto
//                .filter(v -> v.getPatente().equals(patente))  // Filtramos por la patente
//                .findFirst()  // Tomamos el primer vehículo que coincida
//                .orElse(null);  // Si no se encuentra, devolvemos null

    }

    public void socorrerMoto(String patente){

    }






}
