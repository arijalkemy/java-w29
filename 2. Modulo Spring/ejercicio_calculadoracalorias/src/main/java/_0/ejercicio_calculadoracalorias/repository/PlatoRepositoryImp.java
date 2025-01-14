package _0.ejercicio_calculadoracalorias.repository;

import _0.ejercicio_calculadoracalorias.model.Ingredientes;
import _0.ejercicio_calculadoracalorias.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepositoryImp implements PlatoRepository {
    //definir el array de aliminas y leerlos desde el json
    private List<Ingredientes> ingredientesList= new ArrayList<>();

    //DEFINIR EL CONTRUCTOR QUE INVOQUE A LA CARGA DE INGREDIENTES

    public PlatoRepositoryImp() {
        cargarDatosDesdeJson();
        cargarPlatos();
    }


    //CARGAR LOS INGREDIENTES DESDE EL JSON
    private void cargarDatosDesdeJson() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/food.json")) {
            if (inputStream == null) {
                throw new IllegalArgumentException("El archivo food.json no se encuentra en el classpath");
            }
            // Cargar el archivo JSON en la lista
            List<Ingredientes> ingredientes = mapper.readValue(
                    inputStream,
                    new TypeReference<List<Ingredientes>>() {}
            );
            ingredientesList.addAll(ingredientes);
            System.out.println("Datos cargados correctamente desde JSON");
        } catch (Exception e) {
            System.err.println("Error al cargar los datos del JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }


    //definir el array de platos y cargar alguno
    private List<Plato> platosList= new ArrayList<>();

    // Cargar algunos platos con ingredientes
    private void cargarPlatos() {
        // Crear platos con ingredientes

        Plato plato1 = new Plato("Ensalada Mediterránea",250.0);
        plato1.setIngredientes(List.of(
                ingredientesList.stream().filter(i -> i.getName().equals("Tomates")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Aceitunas negras")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Pepino")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Pimiento")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Cebolla tierna")).findFirst().orElse(null)
        ));
        platosList.add(plato1);

        Plato plato2 = new Plato("Sopa de Calabaza y Zanahoria",300.0);
        plato2.setIngredientes(List.of(
                ingredientesList.stream().filter(i -> i.getName().equals("Calabaza")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Zanahoria")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Cebolla")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Apio")).findFirst().orElse(null)
        ));
        platosList.add(plato2);

        Plato plato3 = new Plato("Tacos",300.0);
        plato3.setIngredientes(List.of(
                ingredientesList.stream().filter(i -> i.getName().equals("Pollo")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Tomates")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Pimiento")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Cebolla")).findFirst().orElse(null)
        ));
        platosList.add(plato3);

        Plato plato4 = new Plato("Ensalada de Frutas",200.0);
        plato4.setIngredientes(List.of(
                ingredientesList.stream().filter(i -> i.getName().equals("Arándanos")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Fresas")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Mandarina")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Manzana")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Kiwi")).findFirst().orElse(null)
        ));
        platosList.add(plato4);

        Plato plato5 = new Plato("Pechuga de Pavo a la Parrilla",350.0);
        plato5.setIngredientes(List.of(
                ingredientesList.stream().filter(i -> i.getName().equals("Pavo, Pechuga")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Espárragos")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Ajos")).findFirst().orElse(null)
        ));
        platosList.add(plato5);

        Plato plato6 = new Plato("Bacalao con Papas Cocidas",400.0);
        plato6.setIngredientes(List.of(
                ingredientesList.stream().filter(i -> i.getName().equals("Bacalao fresco")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Papas cocidas")).findFirst().orElse(null),
                ingredientesList.stream().filter(i -> i.getName().equals("Ajos")).findFirst().orElse(null)
        ));
        platosList.add(plato6);

        System.out.println("Platos cargados correctamente.");
    }



    @Override
    public Plato findByName(String name) {
        return platosList.stream().filter(p -> p.getNombre().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
    }






}
