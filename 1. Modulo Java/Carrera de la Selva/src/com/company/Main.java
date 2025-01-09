package com.company;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    //Mapa para informacion de las carreras, se podria borrar en caso que no se necesite.
        Map<Integer, String> informacion_Carreras = new HashMap<Integer, String>() {{
            put(1, "2 km por selva y arroyos.");
            put(2, "5 km por selva, arroyos y barro.");
            put(3, "10 km por selva, arroyos, barro y escalada en piedra.");
        }};


        //Mapa para manejar inscripciones
        /*Estrucutra:
            {
            (nro categoria) key 1: {
                (nro participante) key 1: ["43494560", "Pablo", "Viano", "23", "3492489832","3492489843","A+"]
            },
            key 2: {
                key 30: ["43494321", "Lucia", "Viano", "17", "3492489832","3492489843","A+"],
                key 40: ["434432423", "Joaquin", "Viano", "16", "3492489832","3492489843","A+"]
            }
        }
        * */
        Map<Integer, Map<Integer, String[]>> inscripciones_Carreras = new HashMap<>();

        //Creamos un mapa para cada categoria
        Map<Integer, String[]> carreras_categoria_3 = new HashMap<>();
        Map<Integer, String[]> carreras_categoria_2 = new HashMap<>();
        Map<Integer, String[]> carreras_categoria_1 = new HashMap<>();

        //Carga de participantes
        carreras_categoria_1.put(1, new String[]{"43494560", "Pablo", "Viano", "23", "3492489832","3492489843","A+"});
        carreras_categoria_1.put(2, new String[]{"43499583", "Nicolas", "Viano", "25", "3492489832","3492489843","A-"});
        carreras_categoria_2.put(1,new String[]{"43494321", "Lucia", "Viano", "17", "3492489832","3492489843","A+"});
        carreras_categoria_2.put(2,new String[] {"434432423", "Joaquin", "Viano", "16", "3492489832","3492489843","A+"});
        carreras_categoria_3.put(1, new String[] {"434498943", "Luciano", "Viano", "21", "3492489832","3492489843","O-"});

        //Inscribimos a los participantes
        inscripciones_Carreras.put(1, carreras_categoria_1);
        inscripciones_Carreras.put(2, carreras_categoria_2);
        inscripciones_Carreras.put(3, carreras_categoria_3);

        //Calulamos montos
        double totalRecaudado = 0;
        for (Map.Entry<Integer, Map<Integer, String[]>> outerEntry : inscripciones_Carreras.entrySet()){
            Integer nroCarrera = outerEntry.getKey();
            Map<Integer, String[]> participantes = outerEntry.getValue();

            for (Map.Entry<Integer, String[]> innerEntry : participantes.entrySet()){
                Integer nroParticipante = innerEntry.getKey();
                String[] infoParticipante = innerEntry.getValue();
                int edadParticipante = Integer.parseInt(infoParticipante[3]);
                switch (nroCarrera){
                    case 1:{
                        if (edadParticipante >= 18){
                            totalRecaudado += 1500;
                        }
                        else{
                            totalRecaudado += 1300;
                        }
                        break;
                    }
                    case 2:{
                        if (edadParticipante >= 18){
                            totalRecaudado += 2300;
                        }
                        else{
                            totalRecaudado += 2000;
                        }
                        break;
                    }
                    case 3:{
                            totalRecaudado += 2800;
                        break;
                    }
                }
            }
        }

        //Imprimimos montos
        System.out.println("---------------- Calculamos montos recaudados --------------------");
        System.out.println("El monto total recaudado entre todas las categorias es de: $"+totalRecaudado);
        System.out.println("------------------------------------------------------------------");

        //Desinscribir a un participante (Participante nro 1 de la categoria 2)
        carreras_categoria_2.remove(1);

        //Se podria utilizar funcion para calcular montos
        double totalRecaudado2 = 0;
        for (Map.Entry<Integer, Map<Integer, String[]>> outerEntry : inscripciones_Carreras.entrySet()){
            Integer nroCarrera = outerEntry.getKey();
            Map<Integer, String[]> participantes = outerEntry.getValue();

            for (Map.Entry<Integer, String[]> innerEntry : participantes.entrySet()){
                Integer nroParticipante = innerEntry.getKey();
                String[] infoParticipante = innerEntry.getValue();
                int edadParticipante = Integer.parseInt(infoParticipante[3]);
                switch (nroCarrera){
                    case 1:{
                        if (edadParticipante >= 18){
                            totalRecaudado2 += 1500;
                        }
                        else{
                            totalRecaudado2 += 1300;
                        }
                        break;
                    }
                    case 2:{
                        if (edadParticipante >= 18){
                            totalRecaudado2 += 2300;
                        }
                        else{
                            totalRecaudado2 += 2000;
                        }
                        break;
                    }
                    case 3:{
                        totalRecaudado2 += 2800;
                        break;
                    }
                }
            }
        }
        System.out.println("--------------- Desinscribimos a: Lucia Viano de 17 años de edad, de la categoria 2 -------------");
        System.out.println("El monto total recaudado entre todas las categorias es de: $"+totalRecaudado2);
        System.out.println("-------------------------------------------------------------------------------------------------");

    }
}
