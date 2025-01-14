package parte1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Pinilla", 1241234L, "Edwin");
        Cliente cliente3 = new Cliente("Trejos", 1124314L, "Michell");

        List<Cliente> clienteList = new ArrayList<Cliente>();
        clienteList.add(cliente1);
        clienteList.add(cliente3);
        for (Cliente cliente : clienteList) {
            System.out.println(cliente.toString());
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite el DNI del cliente a borrar: ");
            int dniIngresado = scanner.nextInt();
            boolean bandera = false;

            for (Cliente cliente : clienteList) {
                if (cliente.getDni() == dniIngresado) {
                    clienteList.remove(cliente);
                    bandera = true;
                    break;
                }
            }
            if (!bandera) {
                System.out.println("El cliente no existe");
            }
            else {
                System.out.println("El cliente con DNI: " + dniIngresado + "Fue borrado");
            }
        } catch (Exception e) {
            System.err.println("Entrada no válida. Por favor, ingrese un número válido.");
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite el DNI del cliente a borrar: ");
            int dniABuscar = scanner.nextInt();
            boolean clienteEncontrado = false;

            for (Cliente cliente : clienteList) {
                if (cliente.getDni() == dniABuscar) {
                    cliente.toString();
                    clienteEncontrado = true;
                    break;
                }
            }
            if (!clienteEncontrado) {
                System.out.println("El cliente no existe");
            }
            else {
                System.out.println("El cliente con DNI: " + dniABuscar + "Fue encontrado");
            }
        } catch (Exception e) {
            System.err.println("Entrada no válida. Por favor, ingrese un número válido.");
        }
    }
}