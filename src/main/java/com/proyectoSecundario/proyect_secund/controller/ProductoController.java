package com.proyectoSecundario.proyect_secund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyectoSecundario.proyect_secund.Service.CategoriaService;
import com.proyectoSecundario.proyect_secund.Service.ProductoService;
import com.proyectoSecundario.proyect_secund.Service.VentasService;
import com.proyectoSecundario.proyect_secund.model.Productos;
import com.proyectoSecundario.proyect_secund.util.Alert;

@Controller
@RequestMapping("ventas")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private VentasService ventasService;
	
	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstProducto",productoService.getAll());
		return "ventas/listado";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstCategoria",categoriaService.getAll());
		model.addAttribute("lstVentas",ventasService.getAll());
		model.addAttribute("producto",new Productos());
		return "ventas/nuevo";
}
	@PostMapping("registrar")
	public String registrar(@ModelAttribute Productos producto, Model model, RedirectAttributes flash) {
		var response = productoService.create(producto);
		
		if (!response.success) {
			model.addAttribute("alert",Alert.sweetAlertError(response.mensaje));
			model.addAttribute("lstCategoria",categoriaService.getAll());
			model.addAttribute("lstProducto",productoService.getAll());
			return "ventas/nuevo";
			
		}
		flash.addFlashAttribute("toast",Alert.sweetToast(response.mensaje,"success" , 5000));
		return "redirect:/ventas/listado";
	}
	
	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id,Model model) {
		model.addAttribute("lstCategoria",categoriaService.getAll());
		model.addAttribute("producto",productoService.getOne(id));
		return "ventas/edicion";
	}
	
	@PostMapping("guardar")
	public String guardar(@ModelAttribute Productos producto, Model model, RedirectAttributes flash) {
		var response = productoService.update(producto);
		
		if (!response.success) {
			model.addAttribute("alert",Alert.sweetAlertError(response.mensaje));
			model.addAttribute("lstCategoria",categoriaService.getAll());
			return "ventas/nuevo";
			
		}
		flash.addFlashAttribute("toast",Alert.sweetToast(response.mensaje,"success" , 5000));
		return "redirect:/ventas/listado";
	}
	
}