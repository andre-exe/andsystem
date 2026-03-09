package com.proyecto.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.inventario.model.DetalleCompra;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {

}
