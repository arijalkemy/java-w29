package com.bootcampw29.siniestros_autos.projection;

public interface VehicleEconomicLossTotalProjection {
    Long getId();
    String getPatent();
    String getBrand();
    String getModel();
    Double getTotalEconomicLoss();
}
