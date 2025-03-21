package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISectionRepository extends JpaRepository<Section, Integer> {
    boolean existsBySectionCode(Integer sectionCode);
    Section findBySectionCode(Integer sectionCode);
}
