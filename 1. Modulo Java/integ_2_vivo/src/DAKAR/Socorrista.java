package DAKAR;

import DAKAR.model.Vehiculo;

public class Socorrista <T extends Vehiculo>{
    public void socorrer(T vehiculo){ 
        System.out.println("Socorriendo vehiculo con patente: " + vehiculo.getPatente());
    }
}
