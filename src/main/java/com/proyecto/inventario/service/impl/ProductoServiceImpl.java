package com.proyecto.inventario.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.inventario.dto.producto.ProductoRequestDTO;
import com.proyecto.inventario.dto.producto.ProductoResponseDTO;
import com.proyecto.inventario.mapper.ProductoMapper;
import com.proyecto.inventario.model.Categoria;
import com.proyecto.inventario.model.Producto;
import com.proyecto.inventario.model.Proveedor;
import com.proyecto.inventario.repository.CategoriaRepository;
import com.proyecto.inventario.repository.ProductoRepository;
import com.proyecto.inventario.repository.ProveedorRepository;
import com.proyecto.inventario.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProveedorRepository proveedorRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, ProveedorRepository proveedorRepository, CategoriaRepository categoriaRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.proveedorRepository = proveedorRepository;
        this.categoriaRepository = categoriaRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO dto) {
        // convertir DTO a entidad
        Producto producto = productoMapper.toEntity(dto);
        // buscar proveedor
        Proveedor proveedor = proveedorRepository.findById(dto.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        // buscar categoria
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        // asignar relaciones
        producto.setProveedor(proveedor);
        producto.setCategoria(categoria);
        Producto guardado = productoRepository.save(producto);
        return productoMapper.toDTO(guardado);
    }

    @Override
    public List<ProductoResponseDTO> listarProductos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

}
