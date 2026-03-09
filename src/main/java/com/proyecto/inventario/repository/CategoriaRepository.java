package com.proyecto.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.inventario.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
