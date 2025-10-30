package com.proyectoSecundario.proyect_secund.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoSecundario.proyect_secund.dto.AutenticacionFilter;
import com.proyectoSecundario.proyect_secund.model.Empleados;
import com.proyectoSecundario.proyect_secund.repository.EmpleadoRepository;



@Service
public class AutenticacionService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public Empleados autenticar(AutenticacionFilter filter) {
		return empleadoRepository.findByCuentaAndClave(filter.getCuenta(), filter.getClave());
	}

}
