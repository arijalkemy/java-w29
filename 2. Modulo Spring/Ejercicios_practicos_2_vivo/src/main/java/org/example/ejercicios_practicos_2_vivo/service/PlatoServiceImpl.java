package org.example.ejercicios_practicos_2_vivo.service;

import org.example.ejercicios_practicos_2_vivo.dto.PlatoResponseDto;
import org.example.ejercicios_practicos_2_vivo.entity.Ingrediente;
import org.example.ejercicios_practicos_2_vivo.entity.Plato;
import org.example.ejercicios_practicos_2_vivo.repository.IPlatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlatoServiceImpl implements IPlatoService {
    private final IPlatoRepository platoRepository;

    @Override
    public List<PlatoResponseDto> getAllplatos(List<String> platos) {
        return platos.stream().map(this::getplato).collect(Collectors.toList());
    }

    @Override
    public PlatoResponseDto getplato(String nombre) {

        Plato plato = platoRepository.getPlato(nombre);
        PlatoResponseDto platoResponseDto = new PlatoResponseDto();

        int totalCalorias = getTotalCalorias(plato.getIngredientes());
        Ingrediente ingredienteMayorCalorias = getIngredienteMayorCalorias(plato.getIngredientes());
        List<String> listaIngredientes = plato.getIngredientes().keySet()
                .stream()
                .map(e -> "Nombre: " + e.getNombre() + " Cantidad: " + e.getCaloriasPorUnidad()).collect(Collectors.toList());

        platoResponseDto.setNombre(plato.getNombre());
        platoResponseDto.setCaloriasTotal(totalCalorias);
        platoResponseDto.setIngredientes(listaIngredientes);
        platoResponseDto.setIngredienteMayorCalorias(ingredienteMayorCalorias.getNombre());

        return platoResponseDto;
    }



    private Ingrediente getIngredienteMayorCalorias(Map<Ingrediente, Integer> ingredientes) {
        return ingredientes.entrySet().stream()
                .max((entry1, entry2) -> {
                    int calorias1 = entry1.getKey().getCaloriasPorUnidad() * entry1.getValue();
                    int calorias2 = entry2.getKey().getCaloriasPorUnidad() * entry2.getValue();
                    return Integer.compare(calorias1, calorias2);
                })
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("No hay ingredientes"));
    }

    public int getTotalCalorias(Map<Ingrediente, Integer> ingredientes) {
        return ingredientes.entrySet().stream()
                .mapToInt(e -> e.getKey().getCaloriasPorUnidad() * e.getValue()).sum();
    }
}
