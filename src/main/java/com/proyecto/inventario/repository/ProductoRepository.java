package com.proyecto.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.inventario.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
