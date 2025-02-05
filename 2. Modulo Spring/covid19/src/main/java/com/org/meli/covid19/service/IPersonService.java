package com.org.meli.covid19.service;

import com.org.meli.covid19.dto.RiskGroupPersonDto;

import java.util.List;

public interface IPersonService {
    List<RiskGroupPersonDto> getListRiskGroupPerson();
}
