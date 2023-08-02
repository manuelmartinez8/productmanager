package com.web.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.web.model.MesesEnum;
import com.web.util.ConstantsUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.web.converter.GastosConverter;
import org.web.entity.EGastos;

import com.web.model.Gastos;
import com.web.model.GastosEnum;
import com.web.service.IExpensesServices;

import javax.validation.Valid;

@Tag(name = "Expenses", description = "Expenses management APIs")
@Controller
@RequestMapping("/views/")
public class ExpensesController {
	
	@Autowired
	IExpensesServices service;
	private static final Logger log = LoggerFactory.getLogger(ExpensesController.class);
	ConstantsUtil constantsUtil = new ConstantsUtil();

	@RequestMapping("listAllExpenses")
	public String goToExpensesModule(Model model){
		List<Gastos> allGastos = service.getAllGastos();
		model.addAttribute("titulo", "Modulo de Gastos ");
		model.addAttribute("listadegastos", allGastos);
		log.info("SE LISTARON LOS GASTOS");
		return constantsUtil.VIEW_LISTADO_GASTOS;
	}

	@RequestMapping("listAllExpensesold")
	public String getAllExpenses(Model model) {
		List<Gastos> allGastos = service.getAllGastos();
		model.addAttribute("titulo", "Los Gastos son");
		model.addAttribute("listadegastos", allGastos);
		return constantsUtil.VIEW_LISTADO_GASTOS;
	}
	
	@GetMapping("newexpense")
	public String goToFormNewExpense(Model model) {
	    Gastos g = new Gastos();		 
		List<GastosEnum> lc= service.ListaGastosEnum();
		List<MesesEnum> lm = service.ListaMesesEnum();
		model.addAttribute("titulo", "Formulario Nuevo Gasto");
		model.addAttribute("gasto", g);
		model.addAttribute("categorias", lc);
		model.addAttribute("meses", lm);
		return constantsUtil.FORMULARIO_NUEVO_GASTO;
	}

	@Operation(
			summary = "Endpoint to save a new gasto",
			description = "Endpoint to save a new gasto, set title, kind and category.",
			tags = { "product", "post" })
	@PostMapping("/savegasto")
	public String Guardar(@Valid @ModelAttribute Gastos g,
			BindingResult result, Model model,
						  RedirectAttributes messagesAtributte) {
		if(result.hasErrors()){
			Gastos gasto = new Gastos();
			List<GastosEnum> lc= service.ListaGastosEnum();
			model.addAttribute("titulo", "Formulario Nuevo Gasto");
			model.addAttribute("gasto", gasto);
			model.addAttribute("categorias", lc);
			return constantsUtil.FORMULARIO_NUEVO_GASTO;
		}
			GastosConverter converter = new GastosConverter();
		 	log.info("SE INICIA PROCESO DE GUARDADO DEL NUEVO GASTO " + g.getFechagastos().toString());
			LocalDate pastDate = LocalDate.parse(g.getFechagastos().toString(), DateTimeFormatter.ISO_DATE);
		log.info("PAESE FECHA"+pastDate);

			service.guardar(converter.convertGasto(g));
		messagesAtributte.addFlashAttribute("succes", "GASTO GUARDADO CON EXITO");
		return constantsUtil.REDIRECT_LISTADO_GASTOS;
	}

	@GetMapping("/mes/{mes}")
	public String getForMonth(@PathVariable("mes") String mes, Model model){
		List<Gastos> allGastos = service.getAllGastos();
		List<Gastos> gastosMes = allGastos.stream()
						.filter(gastos -> mes.equals(gastos.getMes())).collect(Collectors.toList());

		model.addAttribute("titulo", "Modulo de Gastos ");
		model.addAttribute("listadegastos", gastosMes);

		log.info("SE LISTARON LOS GASTOS");
		return constantsUtil.VIEW_LISTADO_GASTOS;
	}

	@GetMapping("/editg/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model){
		if(id>0){
			buildModel(id,"Formulario Editar Gasto", model);
		}
		return constantsUtil.FORMULARIO_NUEVO_GASTO;
	}
	@GetMapping("/deleteg/{id}")
	public String deleteGasto(@PathVariable("id") Long id, Model model){
		service.Eliminar(id);
		return constantsUtil.REDIRECT_LISTADO_GASTOS;
	}
	private Model buildModel(Long id, String titulo,Model model){
		EGastos eg = new EGastos();
		if(id>0)
		{
			eg = service.findPorID(id);
		}
		List<GastosEnum> lc= service.ListaGastosEnum();
		model.addAttribute("titulo", titulo);
		model.addAttribute("gasto", eg);
		model.addAttribute("categorias", lc);
		return model;
	}
}
