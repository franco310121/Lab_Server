package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Saludo;

@Repository
public interface SaludoRepository extends JpaRepository<Saludo, Long>{
    Optional<Saludo> findByNombreAndApellido(String nombre, String apellido);
}
