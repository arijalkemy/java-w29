import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args){
        //Categorias
        Map<Integer, ArrayList<String>> categorias = new HashMap<>();
        categorias.put(1, new ArrayList<>());
        categorias.get(1).add("1");
        categorias.get(1).add("Circuito Chico");
        categorias.get(1).add("2 km por selva y arroyos");
        categorias.put(2, new ArrayList<>());
        categorias.get(2).add("2");
        categorias.get(2).add("Circuito Medio");
        categorias.get(2).add("5 km por selva, arroyos y barro");
        categorias.put(3, new ArrayList<>());
        categorias.get(3).add("3");
        categorias.get(3).add("Circuito Avanzado");
        categorias.get(3).add("10 km por selva, arroyos, barro y escalada de piedra");

        //Participantes
        Map<Integer, ArrayList<String>> participante1 = new HashMap<>();
        participante1.put(1, new ArrayList<>());
        participante1.get(1).add(0, "1016057534");
        participante1.get(1).add(1, "Camilo");
        participante1.get(1).add(2, "Sanchez");
        participante1.get(1).add(3, "16");
        participante1.get(1).add(4, "3107685236");
        participante1.get(1).add(5, "3125413674");
        participante1.get(1).add(6, "A+");

        Map<Integer, ArrayList<String>> participante2 = new HashMap<>();
        participante2.put(2, new ArrayList<>());
        participante2.get(2).add(0, "1009451324");
        participante2.get(2).add(1, "Juan");
        participante2.get(2).add(2, "Perez");
        participante2.get(2).add(3, "10");
        participante2.get(2).add(4, "3215644874");
        participante2.get(2).add(5, "3005464157");
        participante2.get(2).add(6, "AB+");

        Map<Integer, ArrayList<String>> participante3 = new HashMap<>();
        participante3.put(3, new ArrayList<>());
        participante3.get(3).add(0, "1021354685");
        participante3.get(3).add(1, "Antonio");
        participante3.get(3).add(2, "Mora");
        participante3.get(3).add(3, "23");
        participante3.get(3).add(4, "3143214765");
        participante3.get(3).add(5, "3134646354");
        participante3.get(3).add(6, "O-");

        Map<Integer, ArrayList<String>> participante4 = new HashMap<>();
        participante4.put(4, new ArrayList<>());
        participante4.get(4).add(0, "1003246584");
        participante4.get(4).add(1, "Pablo");
        participante4.get(4).add(2, "Jaramillo");
        participante4.get(4).add(3, "30");
        participante4.get(4).add(4, "3115454536");
        participante4.get(4).add(5, "3016546764");
        participante4.get(4).add(6, "O+");

        //Inscripciones
        ArrayList<ArrayList<Integer>> inscripciones = new ArrayList<>();
        inscripciones.add(new ArrayList<>());
        inscripciones.add(new ArrayList<>());
        inscripciones.add(new ArrayList<>());
        inscripciones.add(new ArrayList<>());
        inscripciones.getFirst().addFirst(100);
        inscripciones.getFirst().add(1,Integer.parseInt(categorias.get(1).getFirst()));
        inscripciones.get(0).add(2,Integer.parseInt(participante1.get(1).get(0)));
        if (Integer.parseInt(participante1.get(1).get(3)) < 18){
            inscripciones.getFirst().add(3,1300);
        }else {
            inscripciones.getFirst().add(3,1500);
        }

        inscripciones.get(1).add(0,200);
        inscripciones.get(1).add(1,Integer.parseInt(categorias.get(2).getFirst()));
        inscripciones.get(1).add(2,Integer.parseInt(participante2.get(2).get(0)));
        if (Integer.parseInt(participante2.get(2).get(3)) < 18){
            inscripciones.get(1).add(3,2000);
        }else {
            inscripciones.get(1).add(3,2300);
        }

        inscripciones.get(2).add(0,300);
        inscripciones.get(2).add(1,Integer.parseInt(categorias.get(1).getFirst()));
        inscripciones.get(2).add(2,Integer.parseInt(participante4.get(4).get(0)));
        if (Integer.parseInt(participante4.get(4).get(3)) < 18){
            inscripciones.get(2).add(3,1300);
        }else {
            inscripciones.get(2).add(3,1500);
        }

        inscripciones.get(3).add(0,400);
        inscripciones.get(3).add(1,Integer.parseInt(categorias.get(3).getFirst()));
        inscripciones.get(3).add(2,Integer.parseInt(participante3.get(3).get(0)));
        if (Integer.parseInt(participante3.get(3).get(3)) < 18){
            inscripciones.remove(3);
        }else {
            inscripciones.get(3).add(3,2800);
        }

        //Imprimir categorias, participantes e inscripciones
        System.out.println("Categorias: " + categorias);
        System.out.println("Participante1: " + participante1);
        System.out.println("Participante2: " + participante2);
        System.out.println("Participante3: " + participante3);
        System.out.println("Participante4: " + participante4);
        System.out.println("Inscripciones: " + inscripciones);

        //Inscritos por categoria
        System.out.println("---------Inscripciones por categorias---------");
        ArrayList<Integer> inscritosCircuitoChico = new ArrayList<>();
        ArrayList<Integer> inscritosCircuitoMedio = new ArrayList<>();
        ArrayList<Integer> inscritosCircuitoAvanzado = new ArrayList<>();
        for (int i = 0; i < inscripciones.size(); i++){
            if (inscripciones.get(i).get(1) == 1){
                inscritosCircuitoChico.add(inscripciones.get(i).get(0));
                inscritosCircuitoChico.add(inscripciones.get(i).get(2));
            }else if (inscripciones.get(i).get(1) == 2){
                inscritosCircuitoMedio.add(inscripciones.get(i).get(0));
                inscritosCircuitoMedio.add(inscripciones.get(i).get(2));
            }else {
                inscritosCircuitoAvanzado.add(inscripciones.get(i).get(0));
                inscritosCircuitoAvanzado.add(inscripciones.get(i).get(2));
            }
        }
        System.out.println("Los inscritos en la categoria chica son: " + inscritosCircuitoChico);
        System.out.println("Los inscritos en la categoria media son: " + inscritosCircuitoMedio);
        System.out.println("Los inscritos en la categoria avanzada son: " + inscritosCircuitoAvanzado);

        //Eliminar un participante
        System.out.println("---------Eliminando Participante---------");
        try {
            inscripciones.remove(0);
            System.out.println("participane #100 eliminado");
        }catch (Exception e){
            System.out.println("No se puede eliminar el inscrito participante: " + e.getMessage());
        }

        //inscritos por categoria
        System.out.println("---------Inscritos por categoria---------");
        ArrayList<Integer> verificacionPaticipanteChico = new ArrayList<>();
        ArrayList<Integer> verificacionPaticipanteMedio = new ArrayList<>();
        ArrayList<Integer> verificacionPaticipanteAvanzado = new ArrayList<>();
        for (int i = 0; i < inscripciones.size(); i++){
            if (inscripciones.get(i).get(1) == 1){
                verificacionPaticipanteChico.add(inscripciones.get(i).get(0));
                verificacionPaticipanteChico.add(inscripciones.get(i).get(2));
            }else if (inscripciones.get(i).get(1) == 2){
                verificacionPaticipanteMedio.add(inscripciones.get(i).get(0));
                verificacionPaticipanteMedio.add(inscripciones.get(i).get(2));
            }else {
                verificacionPaticipanteAvanzado.add(inscripciones.get(i).get(0));
                verificacionPaticipanteAvanzado.add(inscripciones.get(i).get(2));
            }
        }
        System.out.println("Los inscritos en la categoria chica son: " + verificacionPaticipanteChico);
        System.out.println("Los inscritos en la categoria media son: " + verificacionPaticipanteMedio);
        System.out.println("Los inscritos en la categoria avanzada son: " + verificacionPaticipanteAvanzado);

        //Montos por categoria
        int montosChica = 0;
        int montosMedia = 0;
        int montosAvanzado = 0;
        for (int i = 0; i < inscripciones.size(); i++){
            if (inscripciones.get(i).get(1) == 1){
                montosChica += inscripciones.get(i).get(3);
            }else if (inscripciones.get(i).get(1) == 2){
                montosMedia += inscripciones.get(i).get(3);
            }else {
                montosAvanzado += inscripciones.get(i).get(3);
            }
        }
        System.out.println("---------Montos por categoria---------");
        System.out.println("Los montos para la categoria chica son: " + montosChica);
        System.out.println("Los montos para la categoria media son: " + montosMedia);
        System.out.println("Los montos para la categoria avanzada son: " + montosAvanzado);

        //montos totales
        System.out.println("---------Montos totales-------");
        System.out.println("los montos de todas las categorias son: " + (montosChica + montosMedia + montosAvanzado));

    }
}
