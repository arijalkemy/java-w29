package com.bootcampW22.EjercicioGlobal.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
@SpringBootTest()
public class VehicleRepositoryImplTest {

    @Autowired
    private VehicleRepositoryImpl vehicleRepository;

    @Test
    void findAll(){
        System.out.println(this.vehicleRepository.findAll().get(0).getYear());
        assertFalse(this.vehicleRepository.findAll().isEmpty());
    }

}

