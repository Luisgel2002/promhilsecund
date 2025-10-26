package com.proyectoSecundario.proyect_secund.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoSecundario.proyect_secund.model.Categorias;
import com.proyectoSecundario.proyect_secund.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categorias> getAll(){
		return categoriaRepository.findAll();
	}

}
