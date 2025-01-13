package org.example;

import org.example.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = new Cliente(1193525542L, "David", "Narvaez");
        Cliente cliente2 = new Cliente(11324542L, "Gabriela", "Rodriguez");
        Cliente cliente3 = new Cliente(111452345L, "Juan", "Garcia");
        clientes.add(cliente);
        clientes.add(cliente2);
        clientes.add(cliente3);
        for (Cliente c : clientes) {
            System.out.println("Identificación: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la identificacion del cliente a eliminar: ");
        Long identificacion = scanner.nextLong();
        boolean eliminado = true;
        for (Cliente c : clientes) {
            if (c.getDni().equals(identificacion)) {
                clientes.remove(c);
                System.out.println("Cliente eliminado: " + c.getDni());
                break;
            }
            else {
                eliminado = false;
            }
        }
        if (!eliminado) {
            System.out.println("El cliente no existe");
        }
        System.out.println("Ingrese el identificador del cliente a buscar: ");
        Long identificador = scanner.nextLong();
        boolean buscar = true;
        for (Cliente c : clientes) {
            if (c.getDni().equals(identificador)) {
                System.out.println("El cliente es: ");
                System.out.println("Identificación: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                buscar = true;
            }
            else {
                buscar = false;
            }
        }
        if (!buscar) {
            System.out.println("El cliente no existe");
        }
    }
}