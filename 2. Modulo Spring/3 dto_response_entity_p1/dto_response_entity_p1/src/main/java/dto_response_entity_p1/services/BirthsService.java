package dto_response_entity.services;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

@Service
public class BirthsService{
  public Integer getAge(
    Integer day,
    Integer month,
    Integer year
  ){
    LocalDate birth = LocalDate.of(year, month, day);
    Period diferencia = Period.between(birth, LocalDate.now());
    return diferencia.getYears();
  }
}
