package com.web.controller;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.web.converter.GastosConverter;
import org.web.entity.EGastos;

import com.web.model.Gastos;
import com.web.model.GastosEnum;
import com.web.service.IExpensesServices;

@Tag(name = "Expenses", description = "Expenses management APIs")
@Controller
@RequestMapping("/views/")
public class ExpensesController {
	
	@Autowired
	IExpensesServices service;
	private static final Logger log = LoggerFactory.getLogger(ExpensesController.class);

	@RequestMapping("listAllExpenses")
	public String goToExpensesModule(Model model){
		model.addAttribute("titulo", "Modulo de Gastos");
		log.info("SE LISTARON LOS GASTOS");
		return "/views/listAllExpenses";
	}

	@RequestMapping("listAllExpensesold")
	public String getAllExpenses(Model model) {
		List<Gastos> allGastos = service.getAllGastos();
		model.addAttribute("titulo", "Los Gastos son");
		model.addAttribute("listadegastos", allGastos);
		return "/views/listAllExpenses";
	}
	
	@GetMapping("newexpense")
	public String goToFormNewExpense(Model model) {
	    Gastos g = new Gastos();		 
		List<GastosEnum> lc= service.ListaGastosEnum();		
		model.addAttribute("titulo", "Formulario Nuevo Gasto");
		model.addAttribute("gasto", g);
		model.addAttribute("categorias", lc);
		return "views/frmnewexpense";
	}
	
	@PostMapping("/savegasto")
	public String Guardar(@ModelAttribute Gastos g) {
		GastosConverter converter = new GastosConverter();
		 	log.info("SE INICIA PROCESO DE GUARDADO DEL NUEVO GASTO");

			LocalDate pastDate = LocalDate.parse(g.getFechagastos().toString());
			service.guardar(converter.convertGasto(g));
		return "redirect:/views/listAllExpenses";
	}
	
	
	
	

}
