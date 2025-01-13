package EjerciciosInterfaces.Ejercicio1.interfaces;

public interface Transferencia extends Transaction{
    public void transferir(double monto, String destino);
}
