package com.proyecto.inventario.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.inventario.model.Categoria;
import com.proyecto.inventario.model.Producto;
import com.proyecto.inventario.model.Proveedor;
import com.proyecto.inventario.repository.CategoriaRepository;
import com.proyecto.inventario.repository.ProductoRepository;
import com.proyecto.inventario.repository.ProveedorRepository;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;

    public ProductoController(ProductoRepository productoRepository,
        CategoriaRepository categoriaRepository, ProveedorRepository proveedorRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.proveedorRepository = proveedorRepository;
    }

    //listando todos los productos
    @GetMapping
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    //obtener producto por id
    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    //Borrar producto
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }

    //reistrar nuevo producto
    @PostMapping("/nuevo")
    public Producto registrar(@RequestBody Producto producto) {
        Long categoriaId = producto.getCategoria().getId();
        Categoria categoria = categoriaRepository.findById(categoriaId).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        producto.setCategoria(categoria);
        return productoRepository.save(producto);
    }


}
