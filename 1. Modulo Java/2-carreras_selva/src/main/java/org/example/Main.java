package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ///crear los tres circuitos existentes.
        Map<Integer, List<String>> circuitos = new HashMap<>();
        circuitos.put(1, Arrays.asList("Circuito Chico", "2 km por selva y arroyos"));
        circuitos.put(2, Arrays.asList("Circuito Medio", "5 km por selva, arroyos y barro"));
        circuitos.put(3, Arrays.asList("Circuito Grande", "10 km por selva, arroyos, barro y escalada en piedra"));

        ///crear participantes , datos del participante:
        //número de participante, dni, nombre, apellido, edad, celular, número de emergencia y grupo sanguíneo.
        List<List<Object>> participantes = new ArrayList<List<Object>>();
        participantes.add(Arrays.asList(1, "45654788", "Marcela", "Perez", 27, "3456789699", "3456778778", "A+"));
        participantes.add(Arrays.asList(2, "45633324", "Jose", "Martinez", 43, "3537655456", "3537445543", "B+"));
        participantes.add(Arrays.asList(3, "27647898", "Lucas", "Gonzales", 22, "3472546457", "3472634578", "A-"));
        participantes.add(Arrays.asList(4, "45633777", "Josefina", "Marchal", 21, "353778899", "3537445543", "AB+"));

        ///crear inscripciones, datos: número de inscripción, una categoría,
        ///un participante y el monto a abonar por el participante.

        Map<Integer, List<Object>> inscripcion = new HashMap<>();
        //calculas inscripcion de participante
        int monto1 = calcularMonto(participantes.get(0), 1);
        int monto2 = calcularMonto(participantes.get(1), 2);
        int monto3 = calcularMonto(participantes.get(2), 3);
        int monto4 = calcularMonto(participantes.get(3), 2);

        //inscribir los participantes
        inscripcion.put(1, Arrays.asList(circuitos.get(1),participantes.get(0),monto1));
        inscripcion.put(2, Arrays.asList(circuitos.get(2),participantes.get(1),monto2));
        inscripcion.put(3, Arrays.asList(circuitos.get(3),participantes.get(2),monto3));
        inscripcion.put(4, Arrays.asList(circuitos.get(2),participantes.get(3),monto4));

        //Mostrar inscriptos a una categoria
        mostrarInscriptosCategoria("Circuito Chico", inscripcion);
        mostrarInscriptosCategoria("Circuito Medio", inscripcion);
        mostrarInscriptosCategoria("Circuito Grande", inscripcion);

        //Monto recacudado
        montoRecaudado(inscripcion);

        //desinscribir a un participante
        inscripcion.remove(2);
        System.out.println("se desinscribio a un participante del circuito 2");
        mostrarInscriptosCategoria("Circuito Medio", inscripcion);

        //monto recaudado
        montoRecaudado(inscripcion);


    }
    //función para calcular monto de inscripción
    public static int calcularMonto (List<Object> participante, int categoria){
        int edad = (int) participante.get(4);
        int monto =0;
        if (categoria == 1){
            if (edad < 18){
                monto= 1300;
            }else{
                monto= 1500;
            }
        }else if (categoria == 2){
            if (edad < 18){
                monto = 2000;
            }else{
                monto= 2300;
            }
        }else if (categoria == 3){
            if (edad < 18){
                throw new RuntimeException("No se permite inscribir menores en la categoria avanzado");
            }else{
                monto = 2800;
            }
        }
        return monto;
    }

    ///mostrar inscriptos a una categoria
    public static void mostrarInscriptosCategoria(String categoria, Map<Integer, List<Object>> inscrip) {
        for (Map.Entry<Integer, List<Object>> entry : inscrip.entrySet()) {
            // Obtener el circuito (que es una lista de String) de la inscripción
            List<String> circuito =  (List<String>) entry.getValue().get(0); // Primer elemento de la lista es el circuito

            // Buscar la clave del circuito en el mapa 'circuitos'

            if (circuito.get(0).equals(categoria)) {
                // obtener datos del participante
                List<Object> datosPart = (List<Object>) entry.getValue().get(1);

                System.out.println("Nro de inscripción: " +entry.getKey()+ ", Datos del participante: Nro de participante: " +datosPart.get(0) + ", DNI: " +datosPart.get(1) + ", Nombre: " +datosPart.get(2)+ ", Apellido: " +datosPart.get(3)+ ", Edad: " +datosPart.get(4)+ ", Celular: " +datosPart.get(5)+ ", Nro de emergencia: " +datosPart.get(6)+ ", Grupo sanguineo: " +datosPart.get(7)) ;
            }

        }
    }

    public static void montoRecaudado (Map<Integer, List<Object>> inscripciones) {
        int montocat1=0;
        int montocat2=0;
        int montocat3=0;
        int montoTotal=0;
        for (Map.Entry<Integer, List<Object>> entry : inscripciones.entrySet()) {
            //Obtener monto por categoria
            List<String> circuito =  (List<String>) entry.getValue().get(0);
            int monto = (int) entry.getValue().get(2);
            if (circuito.get(0).equals("Circuito Chico")){
                montocat1=montocat1 + monto;
            }else if (circuito.get(0).equals("Circuito Medio")) {
                montocat2=montocat2 + monto;
            }else if (circuito.get(0).equals("Circuito Grande")) {
                montocat3=montocat3 + monto;
            }

            montoTotal=montoTotal+monto;
        }

        System.out.println("El monto total es: " + montoTotal);
        System.out.println("El monto recaudado en la categoria 1 es: " + montocat1);
        System.out.println("El monto recaudado en la categoria 2 es: " + montocat2);
        System.out.println("El monto recaudado en la categoria 3 es: " + montocat3);

    }
}