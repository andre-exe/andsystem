package com.proyecto.inventario.service;

import java.util.List;

import com.proyecto.inventario.dto.producto.ProductoRequestDTO;
import com.proyecto.inventario.dto.producto.ProductoResponseDTO;

public interface ProductoService {

    ProductoResponseDTO crearProducto(ProductoRequestDTO dto);
    List<ProductoResponseDTO> listarProductos();
}
