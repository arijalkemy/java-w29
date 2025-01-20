import clientes.Basico;
import clientes.Colaborador;
import clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to JoJo bank\n");
        Ejecutivo ejecutivo = new Ejecutivo();
        System.out.println("Ejecutivo realizando transacciones: \n");
        ejecutivo.deposito();
        System.out.println("\n");
        ejecutivo.transferencia();
        System.out.println("\n");
        Basico basico = new Basico();
        System.out.println("Basico realizando transacciones: \n");
        basico.consultaDeSaldo();
        System.out.println("\n");
        basico.pagoDeServicios();
        System.out.println("\n");
        basico.retiroDeEfectivo();
        System.out.println("\n");
        Colaborador colaborador = new Colaborador();
        System.out.println("Colaborador realizando transacciones: \n");
        colaborador.consultaDeSaldo();
        System.out.println("\n");
        colaborador.retiroDeEfectivo();
        System.out.println("Fin del programa :D \n");
    }
}