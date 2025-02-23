package com.hqlvivo.hqlvivo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TotalLostDto{
    private List<SiniestroDto> siniestroDtoList;
    private Double total;

}
