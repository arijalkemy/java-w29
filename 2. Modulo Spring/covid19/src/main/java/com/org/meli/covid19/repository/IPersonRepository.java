package com.org.meli.covid19.repository;


import com.org.meli.covid19.dto.RiskGroupPersonDto;
import com.org.meli.covid19.entity.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> findRiskGroup();
}
