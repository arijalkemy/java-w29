package com.example.demo.repository;

import com.example.demo.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Date;
import java.util.List;


public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria,String> {
    List<ObraLiteraria> findByAutor(String autor);
    List<ObraLiteraria> findByNombreContaining(String nombre);
    List<ObraLiteraria> findTop5ByOrderByCantPaginasDesc();
    List<ObraLiteraria> findByAnioPublicacionBefore(Date fecha);
    List<ObraLiteraria> findByEditorial(String editorial);
}
