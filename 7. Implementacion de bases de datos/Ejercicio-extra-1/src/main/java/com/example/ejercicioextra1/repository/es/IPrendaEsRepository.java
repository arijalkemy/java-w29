package com.example.ejercicioextra1.repository.es;

import com.example.ejercicioextra1.entity.es.PrendaDocument;
import com.example.ejercicioextra1.entity.es.VentaDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface IPrendaEsRepository extends ElasticsearchRepository<PrendaDocument, Long> {
    List<PrendaDocument> findAllByTalle(String talle);
    List<PrendaDocument> findAllByNombre(String nombre);
    List<PrendaDocument> findAllByVentaId(Long ventaId);
}
