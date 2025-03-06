package com.bootcampW22.EjercicioGlobal.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.util.ResourceUtils;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestVehiclesUtil {

  public static void resetJSONFile() throws FileNotFoundException, JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    File file = ResourceUtils.getFile("classpath:vehicles_100.json");
    PrintWriter writer = new PrintWriter(file);
    writer.print(mapper.writeValueAsString(getSomeVehicles()));
    writer.close();
  }


  public static List<Vehicle> getSomeVehicles(){
    return List.of(
      new Vehicle(
        1L, 
        "Pontiac",
        "Fiero",
        "6603",
        "Mauv",
        1986,
        "85",
        2,
        "gasoline",
        "semi-automatic",
        105.43,
        280.28,
        288.8
      ),
      new Vehicle(
        2L,
        "Chevrolet",
        "Camaro",
        "6604",
        "Red",
        1986,
        "85",
        2,
        "gasoline",
        "semi-automatic",
        105.43,
        280.28,
        288.8
      ),
      new Vehicle(
        3L,
        "Renault",
        "Clio",
        "6605",
        "Blue",
        2000,
        "85",
        2,
        "gasoline",
        "semi-automatic",
        105.43,
        280.28,
        288.8
      ),
      new Vehicle(
        4L,
        "BMW",
        "X5",
        "6606",
        "Black",
        2010,
        "85",
        2,
        "gasoline",
        "semi-automatic",
        105.43,
        280.28,
        288.8
      ),
      new Vehicle(
        5L,
        "Audi",
        "A3",
        "6607",
        "White",
        2015,
        "85",
        2,
        "gasoline",
        "semi-automatic",
        105.43,
        280.28,
        288.8
      )
      ,
      new Vehicle(
        6L,
        "Pontiac",
        "GTO",
        "6608",
        "Green",
        1967,
        "85",
        2,
        "gasoline",
        "manual",
        105.43,
        280.28,
        288.8
      ),
      new Vehicle(
        7L,
        "Pontiac",
        "Firebird",
        "6609",
        "Yellow",
        1970,
        "85",
        2,
        "gasoline",
        "manual",
        105.43,
        280.28,
        288.8
      ),
      new Vehicle(
        8L,
        "Pontiac",
        "Grand Prix",
        "6610",
        "Silver",
        1980,
        "85",
        2,
        "gasoline",
        "automatic",
        105.43,
        280.28,
        288.8
      )
    );
  }
}
