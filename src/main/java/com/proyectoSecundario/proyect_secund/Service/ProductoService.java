package com.proyectoSecundario.proyect_secund.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoSecundario.proyect_secund.dto.ResultadoResponse;
import com.proyectoSecundario.proyect_secund.model.Productos;
import com.proyectoSecundario.proyect_secund.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository productoRepository;
	
	public List<Productos> getAll() {
		return productoRepository.findAll();
	}
	
	public ResultadoResponse create(Productos producto) {
		try {
			
			Productos productoRegistrado = productoRepository.save(producto);
			String mensaje = String.format("Producto registrado con Id %s",productoRegistrado.getIdProducto());
			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Error en ProductoService: "+e.getMessage());
		}
	}
	
	public Productos getOne(Integer id) {
		return productoRepository.findById(id).orElseThrow();
	}
	
	public ResultadoResponse update(Productos producto) {
		try {
			Productos productoRegistrado = productoRepository.save(producto);
			String mensaje = String.format("Producto actualizado con Id %s",productoRegistrado.getIdProducto());
			return new ResultadoResponse(true, mensaje);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Error en ProductoService: "+e.getMessage());
		}
	}
}
