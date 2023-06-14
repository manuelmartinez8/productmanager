package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/ii")
	public String Welcome(Model model) {
		model.addAttribute("bienvenida", "hola desde thymeleaf");
		return "index";
	}
}
