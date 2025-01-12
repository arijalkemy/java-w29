package ejercicio3.alimenticios;

public interface Carnivoro {

    default void comerCarne(){
        System.out.println("Comiendo Carne");
    }
}
