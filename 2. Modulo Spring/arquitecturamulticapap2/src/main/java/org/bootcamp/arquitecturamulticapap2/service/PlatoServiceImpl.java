package org.bootcamp.arquitecturamulticapap2.service;

import org.bootcamp.arquitecturamulticapap2.dto.response.IngredienteDTO_Out;
import org.bootcamp.arquitecturamulticapap2.dto.request.PlatoDTO_In;
import org.bootcamp.arquitecturamulticapap2.dto.response.PlatoDTO_Out;
import org.bootcamp.arquitecturamulticapap2.repository.IIngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlatoServiceImpl implements IPlatoService{

    private final IIngredienteRepository ingredienteRepository;

    @Override
    public PlatoDTO_Out calcularCalorias(PlatoDTO_In plato) {
        String ingredienteCalorico = "";
        Integer totalCalorias = 0;

        List<IngredienteDTO_Out> lista = listadoDeIngredientes(plato);

        IngredienteDTO_Out io = ingredienteConMasCalorias(lista);
        if(io != null){
            ingredienteCalorico = io.getName();
        }

        totalCalorias = sumatoriaDeCalorias(lista);

        return new PlatoDTO_Out(plato.getName(), plato.getPeso(), (int) (totalCalorias * plato.getPeso()), lista, ingredienteCalorico);


    }

    @Override
    public List<PlatoDTO_Out> calcularCaloriasListado(List<PlatoDTO_In> platos) {
        List<PlatoDTO_Out> platosDTO = new ArrayList<>();
        platos.forEach(p -> platosDTO.add(this.calcularCalorias(p)));
        return platosDTO;
    }

    private static Integer sumatoriaDeCalorias(List<IngredienteDTO_Out> lista) {
        Integer totalCalorias;
        totalCalorias = lista.stream()
                .mapToInt(IngredienteDTO_Out::getCalories)
                .sum();
        return totalCalorias;
    }

    private static IngredienteDTO_Out ingredienteConMasCalorias(List<IngredienteDTO_Out> lista) {
        IngredienteDTO_Out io = lista.stream()
                .max(Comparator.comparingInt(IngredienteDTO_Out::getCalories))
                .orElse(null);
        return io;
    }

    private List<IngredienteDTO_Out> listadoDeIngredientes(PlatoDTO_In plato) {
        List<IngredienteDTO_Out> lista = plato.getIngredientes().stream()
                .map(i -> this.ingredienteRepository.getByName(i.getName()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return lista;
    }
}