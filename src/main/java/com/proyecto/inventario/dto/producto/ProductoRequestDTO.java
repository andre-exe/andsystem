package com.proyecto.inventario.dto.producto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductoRequestDTO {

    private String nombre;

    private String descripcion;

    private BigDecimal precioCompra;

    private BigDecimal precioVenta;

    private Integer stock;

    private Long proveedorId;

    private Long categoriaId;
}
