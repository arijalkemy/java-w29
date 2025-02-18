package ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.repository;

import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.model.ObrasLiterarias;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObrasLiteriariasRespository extends ElasticsearchRepository<ObrasLiterarias,String> {
    //Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    @Query("{\"match\": {\"autor\": \"?0\"}}")
    List<ObrasLiterarias> buscarPorAutor(String autor);

    //Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    @Query("{\"match\":{\"nombre\":\"?0\"}}")
    List<ObrasLiterarias> buscarPorNombre(String nombre);

    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.

    //Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    @Query("{\"range\": {\"ano\": {\"lt\": \"?0\"}}}")
    List<ObrasLiterarias> findByAnioPublicacionBefore(int anio);

    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    @Query("{\"match\":{\"editoria\":\"?0\"}}")
    List<ObrasLiterarias> findByEditorial(String editorial);


}
