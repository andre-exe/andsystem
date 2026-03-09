package com.proyecto.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.inventario.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

}
