package _0.ejercicio_calculadoracalorias.service;
import _0.ejercicio_calculadoracalorias.dto.PlatoDTO;
import _0.ejercicio_calculadoracalorias.model.Ingredientes;
import _0.ejercicio_calculadoracalorias.model.Plato;
import _0.ejercicio_calculadoracalorias.repository.PlatoRepositoryImp;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImp implements PlatoService {

    private PlatoRepositoryImp repository;

    public PlatoServiceImp(PlatoRepositoryImp repository) {
        this.repository = repository;
    }

    @Override
    public PlatoDTO calcularCalorias(String n) {
        ObjectMapper mapper = new ObjectMapper();
        Plato plato = repository.findByName(n);
        PlatoDTO pdto = mapper.convertValue(plato,PlatoDTO.class);

        //calcular calorias
        int caloriasTotales = 0;
        for (Ingredientes ingrediente : pdto.getListIngredientes()) {
            caloriasTotales += ingrediente.getCalories();
        }
        pdto.setCaloriasPlato(caloriasTotales);
        buscarIngredienteCalorico(pdto);

        return pdto;
    }

    public void buscarIngredienteCalorico(PlatoDTO p){

        Ingredientes ingredienteMaxCalorias = null;
        int maxCalorias = Integer.MIN_VALUE;

        // Recorrer la lista de ingredientes y encontrar el que tenga más calorías
        for (Ingredientes ingrediente : p.getListIngredientes()) {
            if (ingrediente.getCalories() > maxCalorias) {
                maxCalorias = ingrediente.getCalories();
                ingredienteMaxCalorias = ingrediente;
            }
        }
        p.setIngredienteCalorico(ingredienteMaxCalorias);
    }
}
