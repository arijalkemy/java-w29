package service;

import model.Joya;

import java.util.List;

public interface IJoyaService {
    List<Joya> getAllJoya();
    Joya findJoya(Long id);
    void saveJoya(Joya joya);
    void deleteJoya(Long id);
    Joya updateJoya(Long id, Joya joya);
}
