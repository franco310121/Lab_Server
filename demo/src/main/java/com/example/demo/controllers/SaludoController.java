package com.example.demo.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Saludo;
import com.example.demo.services.SaludoService;

@RestController
@RequestMapping("/api/saludos")
public class SaludoController {
    @Autowired
    private SaludoService saludoService;

    @PostMapping
    public CompletableFuture<ResponseEntity<Saludo>> crearSaludo(@RequestBody Saludo saludo) {
        return saludoService.guardarSaludo(saludo)
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Saludo>> obtenerPorId(@PathVariable Long id) {
        return saludoService.obtenerPorId(id)
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/buscar")
    public CompletableFuture<ResponseEntity<Saludo>> obtenerPorNombreYApellido(
            @RequestParam String nombre,
            @RequestParam String apellido) {
        return saludoService.obtenerPorNombreYApellido(nombre, apellido)
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<Saludo>>> listarTodos() {
        return saludoService.listarTodos()
                .thenApply(ResponseEntity::ok);
    }
}
