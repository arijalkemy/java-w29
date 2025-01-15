//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.repository;

import com.example.demo.model.Deportista;
import java.util.List;

public interface IDeportistaRepository {
    Deportista encontrarPorNombre(String nombre);

    List<Deportista> encontrarTodos();
}
