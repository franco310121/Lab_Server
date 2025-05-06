package com.example.demo.servicesImpl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Saludo;
import com.example.demo.repositories.SaludoRepository;
import com.example.demo.services.SaludoService;


@Service
public class SaludoServiceImpl implements SaludoService{
    @Autowired
    private SaludoRepository saludoRepository;

    @Override
    public CompletableFuture<Saludo> guardarSaludo(Saludo saludo) {
        return CompletableFuture.supplyAsync(() -> saludoRepository.save(saludo));
    }

    @Override
    public CompletableFuture<Saludo> obtenerPorId(Long id) {
        return CompletableFuture.supplyAsync(() -> 
            saludoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Saludo no encontrado"))
        );
    }

    @Override
    public CompletableFuture<Saludo> obtenerPorNombreYApellido(String nombre, String apellido) {
        return CompletableFuture.supplyAsync(() -> 
            saludoRepository.findByNombreAndApellido(nombre, apellido)
                .orElseThrow(() -> new RuntimeException("Saludo no encontrado"))
        );
    }

    @Override
    public CompletableFuture<List<Saludo>> listarTodos() {
        return CompletableFuture.supplyAsync(saludoRepository::findAll);
    }
}
