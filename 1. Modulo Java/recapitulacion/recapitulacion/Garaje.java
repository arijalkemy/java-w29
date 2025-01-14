package recapitulacion;

public class Garaje {
    public Integer id;
    public Vehiculo[] listaVehiculos;

    public Garaje(Integer id, Vehiculo[] listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vehiculo[] getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(Vehiculo[] listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
