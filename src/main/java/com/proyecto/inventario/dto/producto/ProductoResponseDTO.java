package com.proyecto.inventario.dto.producto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductoResponseDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private BigDecimal precioCompra;

    private BigDecimal precioVenta;

    private Integer stock;

    private String proveedor;

    private String categoria;
}
