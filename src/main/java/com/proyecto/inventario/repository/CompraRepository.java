package com.proyecto.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.inventario.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
