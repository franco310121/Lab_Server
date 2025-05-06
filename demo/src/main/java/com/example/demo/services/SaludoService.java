package com.example.demo.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;


import com.example.demo.entities.Saludo;

public interface SaludoService {
    CompletableFuture<Saludo> guardarSaludo(Saludo saludo);
    CompletableFuture<Saludo> obtenerPorId(Long id);
    CompletableFuture<Saludo> obtenerPorNombreYApellido(String nombre, String apellido);
    CompletableFuture<List<Saludo>> listarTodos();
}
