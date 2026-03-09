package com.proyecto.inventario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.inventario.dto.producto.ProductoRequestDTO;
import com.proyecto.inventario.dto.producto.ProductoResponseDTO;
import com.proyecto.inventario.model.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    Producto toEntity(ProductoRequestDTO dto);

    @Mapping(source = "proveedor.nombre", target = "proveedor")
    @Mapping(source = "categoria.nombre", target = "categoria")
    ProductoResponseDTO toDTO(Producto entity);
    
}