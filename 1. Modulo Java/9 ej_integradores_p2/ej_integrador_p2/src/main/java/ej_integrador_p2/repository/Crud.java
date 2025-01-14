package ej_integrador_p2.repository;

import java.util.*;

public interface Crud<T> {
  public void save(T t);
  public Optional<T> findById(String dni);
  public List<T> findAll();
  public void update(String dni);
  public void delete(String dni);
}