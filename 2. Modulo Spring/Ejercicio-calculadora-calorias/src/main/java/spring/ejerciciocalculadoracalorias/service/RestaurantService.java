package spring.ejerciciocalculadoracalorias.service;

import org.springframework.stereotype.Service;
import spring.ejerciciocalculadoracalorias.dto.request.PlatoDTO;
import spring.ejerciciocalculadoracalorias.dto.response.InfoPlatoDTO;
import spring.ejerciciocalculadoracalorias.model.Ingrediente;
import spring.ejerciciocalculadoracalorias.model.Plato;
import spring.ejerciciocalculadoracalorias.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService implements IRestaurantService {
    private RestaurantRepository repository;

    public RestaurantService() {
        this.repository = new RestaurantRepository();
    }

    @Override
    public InfoPlatoDTO getInfoPlato(PlatoDTO platoInfoRequest) {
        Plato plato = repository.getPlatoByName(platoInfoRequest.getNombre());
        List<String> ingredientes = plato.getIngredientes();
        int peso = platoInfoRequest.getPeso();
        int pesoPorIngrediente = peso / ingredientes.size();
        Ingrediente ingredienteMasCalorico = null;
        int caloriasTotales = 0;
        for (String nombreIngrediente : ingredientes) {
            Ingrediente ingrediente = repository.getIngredienteByName(nombreIngrediente);
            int calorias = ingrediente.getCaloriasPorPeso(pesoPorIngrediente);
            caloriasTotales += calorias;
            if (ingredienteMasCalorico == null ||
                    calorias > ingredienteMasCalorico.getCaloriasPorPeso(pesoPorIngrediente)) {
                ingredienteMasCalorico = ingrediente;
            }
        }
        return new InfoPlatoDTO(
                platoInfoRequest.getNombre(),
                caloriasTotales,
                ingredientes,
                ingredienteMasCalorico
        );
    }

}
