package com.example.implnosqlvivo.repository;

import com.example.implnosqlvivo.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    List<ObraLiteraria> findByAutor(String autor);

    List<ObraLiteraria> findByNombreContaining(String palabraClave);

    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();

    List<ObraLiteraria> findByAnioPublicacionLessThan(int anio);

    List<ObraLiteraria> findByEditorial(String editorial);

}
