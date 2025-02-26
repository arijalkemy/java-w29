package com.autos.empresaseguros.repository;

import com.autos.empresaseguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
}