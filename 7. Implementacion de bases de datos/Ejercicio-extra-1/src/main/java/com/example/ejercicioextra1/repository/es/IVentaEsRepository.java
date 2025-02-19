package com.example.ejercicioextra1.repository.es;

import com.example.ejercicioextra1.entity.es.VentaDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface IVentaEsRepository extends ElasticsearchRepository<VentaDocument, Long> {
    List<VentaDocument> findAllByFecha(LocalDate fecha);

}
