package org.example;

import org.example.clientes.Basico;
import org.example.clientes.Colaborador;
import org.example.clientes.Ejecutivo;
import org.example.tipos.PagosServicio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Basico basico = new Basico();
        Ejecutivo ejecutivo = new Ejecutivo();
        Colaborador colaborador = new Colaborador();
        System.out.println("                                                  ");
        System.out.println("Pruebas exitosas para un Ejecutivo y una fallida: ");
        ejecutivo.deposito();
        ejecutivo.transferencia();
        ejecutivo.consulta();
        System.out.println("                                                  ");
        System.out.println("Pruebas exitosas para un Básico y una fallida: ");
        basico.consulta();
        basico.pagosServicio();
        basico.retiro();
        basico.deposito();
        System.out.println("                                                  ");
        System.out.println("Pruebas exitosas para un Colaborador y una fallida: ");
        colaborador.retiro();
        colaborador.consulta();
        colaborador.deposito();
    }
    }