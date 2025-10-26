package com.proyectoSecundario.proyect_secund.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoSecundario.proyect_secund.model.Ventas;
import com.proyectoSecundario.proyect_secund.repository.VentasRepository;

@Service
public class VentasService {

	@Autowired
	private VentasRepository ventasRepository;
	
	public List<Ventas>getAll(){
		return ventasRepository.findAll();
	}
}
