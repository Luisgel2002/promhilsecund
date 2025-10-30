package com.proyectoSecundario.proyect_secund.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyectoSecundario.proyect_secund.model.Empleados;

public interface EmpleadoRepository extends JpaRepository<Empleados, Integer> {
	Empleados findByCuentaAndClave(String cuenta, String clave);
}
