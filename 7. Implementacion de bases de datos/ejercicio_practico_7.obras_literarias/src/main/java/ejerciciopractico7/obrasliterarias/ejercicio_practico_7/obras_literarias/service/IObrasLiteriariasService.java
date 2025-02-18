package ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.service;

import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.dto.MessageDto;
import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.dto.ObrasLiterariasDto;

import java.util.List;

public interface IObrasLiteriariasService {
    //CREAR OBRAS LITERIARIAS
    MessageDto saveObras(ObrasLiterariasDto obrasLiterariasDto);

    //OBTENER TODAS LAS OBRAS
    List<ObrasLiterariasDto> searchAllObras();

    //Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    List<ObrasLiterariasDto> searchAllObrasPorAutor(String autor);
    //Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    List<ObrasLiterariasDto> searchAllObrasPorTitulo(String titulo);
    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    //Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    List<ObrasLiterariasDto> searchAllObrasPorAño(int año);
    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    List<ObrasLiterariasDto> searchAllObrasPorEditorial(String editorial);
}
