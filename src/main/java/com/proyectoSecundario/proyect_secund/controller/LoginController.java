package com.proyectoSecundario.proyect_secund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyectoSecundario.proyect_secund.dto.AutenticacionFilter;
import com.proyectoSecundario.proyect_secund.model.Empleados;
import com.proyectoSecundario.proyect_secund.util.Alert;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private com.proyectoSecundario.proyect_secund.Service.AutenticacionService autenticacionService;

	@GetMapping({ "/", "login" })
	public String login(Model model) {
		model.addAttribute("filter", new AutenticacionFilter());
		return "login";
	}

	@PostMapping("iniciar-sesion")
	public String iniciarSesion(@ModelAttribute AutenticacionFilter filter, Model model, RedirectAttributes flash,
			HttpSession session) {
		
		Empleados empleados = autenticacionService.autenticar(filter);
		
		if (empleados == null) {
			model.addAttribute("alert", Alert.sweetAlertError("Credenciales incorrectas"));
			model.addAttribute("filter", new AutenticacionFilter());
			return "login";
		}
		
		if (!empleados.getActivo()) {
			model.addAttribute("alert", Alert.sweetAlertInfo("empleado inactivo"));
			model.addAttribute("filter", new AutenticacionFilter());
			return "login";
		}
		
		session.setAttribute("idEmpleado", empleados.getIdEmpleado());
		session.setAttribute("nombreCompleto", empleados.getNombreEmpleado());
		
		flash.addFlashAttribute("alert", Alert.sweetImageUrl(
				"Bienvenido a promhil", 
				empleados.getNombreEmpleado(), 
				"/assets/img/mapache_pedro.gif"));
		
		return "redirect:/dashboard";
	}

	@GetMapping("dashboard")
	public String home() {
		return "dashboard";
	}
	
	@GetMapping("cerrar-sesion")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
