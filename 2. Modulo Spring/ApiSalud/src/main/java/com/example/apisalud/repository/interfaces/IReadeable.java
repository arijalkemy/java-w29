package com.example.apisalud.repository.interfaces;

import java.util.List;

public interface IReadeable <T>{
    List<T> getAll();
}
