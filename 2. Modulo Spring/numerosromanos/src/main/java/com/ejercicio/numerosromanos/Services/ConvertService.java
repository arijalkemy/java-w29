package com.ejercicio.numerosromanos.Services;

import com.ejercicio.numerosromanos.Repositories.ConvertRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ConvertService {

    @Autowired
    private ConvertRepository convertRepository;

    public Integer convertRomanNumber(String romanNumber) {
        Map<String, Integer> romanMap2 = convertRepository.getRomanMap();
        if (romanMap2.containsKey(romanNumber)) {
            return romanMap2.get(romanNumber.toUpperCase());
        }
        return -1;
    }
}
