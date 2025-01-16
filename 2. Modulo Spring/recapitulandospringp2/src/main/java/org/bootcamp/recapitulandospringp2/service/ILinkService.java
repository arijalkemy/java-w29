package org.bootcamp.recapitulandospringp2.service;

import org.bootcamp.recapitulandospringp2.dto.request.LinkDto;
import org.bootcamp.recapitulandospringp2.dto.response.LinkResponseDto;

public interface ILinkService {
    LinkResponseDto crearLink(LinkDto link);
    String redireccionar(Integer linkId);
    Integer getCantidadVisitas(Integer linkId);
    void invalidateLink(Integer linkId);
    void validatePassword(String password);
}
