package ejercicios.meli.services;

import ejercicios.meli.entity.ObraLitearia;

import java.util.List;

public interface ObraLiterariaService {
    ObraLitearia save(ObraLitearia obraLitearia);

    List<ObraLitearia> getByAutor(String autor);

    List<ObraLitearia> getByNombre(String nombre);

    List<ObraLitearia> getTop5ObrasLiterarias();

    List<ObraLitearia> getByBeforeThanAnio(Integer anio);

    List<ObraLitearia> getByEditorial(String editorial);
}
