package com.web.controller;

 
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web.entity.EUser;

import com.web.model.User;
import com.web.service.IUserService;

@Controller
@RequestMapping("/views/")
public class UserController {

	@Autowired
	IUserService service;
	
	@RequestMapping("listUser")
	public String getUser(Model model) {
		List<User> allUser = new ArrayList<User>();
		allUser=service.getAllUser();
		model.addAttribute("titulo", "Los Usuarios");
		model.addAttribute("listadeusuarios", allUser);
		return "/views/listUser";
	}
	
	@PostMapping("/saveuser")
	public String Guardar(@ModelAttribute EUser eu) {
		String url="";
		try {
//		Date d=	java.util.Date.from( Instant.now());
//		eu.setFechaNacimiento(d);
			service.guardar(eu);
			System.out.println("CLIENTE GUARDADO CON EXITO!!");			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "redirect:/views/listUser";		
	}
	
	@GetMapping("nu")
	public String nuevoUsuario(Model model) {
		User u = new User();		 		
		model.addAttribute("titulo", "Formulario Nuevo Usuario");
		model.addAttribute("usuario", u);
		return "/views/frmnuevousuario";
	}
	
	

}
