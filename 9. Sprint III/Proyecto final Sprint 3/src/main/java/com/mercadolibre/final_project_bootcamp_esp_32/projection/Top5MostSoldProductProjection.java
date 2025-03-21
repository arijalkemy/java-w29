package com.mercadolibre.final_project_bootcamp_esp_32.projection;

public interface Top5MostSoldProductProjection {
    Integer getProductId();
    String getProductName();
    Long getTotalSold();
}
