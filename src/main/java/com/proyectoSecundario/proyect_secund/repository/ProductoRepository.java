package com.proyectoSecundario.proyect_secund.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoSecundario.proyect_secund.model.Productos;

public interface ProductoRepository extends JpaRepository<Productos, Integer>{
	List<Productos>findAll();
}
