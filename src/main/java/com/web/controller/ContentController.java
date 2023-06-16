package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.web.entity.EContent;
import org.web.entity.EProduct;

import com.web.model.CategoriasContenidoEnum;
import com.web.model.CategoriasProductosEnum;
import com.web.model.Content;
import com.web.model.Product;
import com.web.service.ICategoriasContent;
import com.web.service.IContentService;

@Controller
@RequestMapping("/views/")
public class ContentController {
	
	@Autowired
	ICategoriasContent icategoriasContent;
	@Autowired
	IContentService service;
	private static final Logger log = LoggerFactory.getLogger(ContentController.class);
	
	@RequestMapping("listContent")
	public String getContent(Model model) {
//		List<Content> allcontent = new ArrayList<Content>();
//		allcontent = service.getAllContent();
//		model.addAttribute("titulo", "Contenido");
//		model.addAttribute("listadecontenidos", allcontent);	
		AllContent(model);
		return "/views/listContent";
	}
	
	@GetMapping("nc")
	public String nuevoContenido(Model model) {
		Content c = new Content();
		List<CategoriasContenidoEnum> lc= icategoriasContent.ListaCategoriasEnum(); 
		c.setId(Long.valueOf(1));
		model.addAttribute("titulo", "Formulario Nuevo Contenido");
		model.addAttribute("contenido", c);
		model.addAttribute("categorias", lc);
		return "/views/frmnuevocontenido";
	}
	
	@PostMapping("/savecontent")
	public String GuardarContenido(@Valid @ModelAttribute EContent c,
			BindingResult result, Model model,
			RedirectAttributes messagesAtributte) {
		
		List<CategoriasContenidoEnum> lc= icategoriasContent.ListaCategoriasEnum();
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Nuevo Contenido");
			model.addAttribute("contenido", c);
			model.addAttribute("categorias", lc);
		System.out.println("DEBE CARGAR TODOS LOS DATOS!!");			
		return "/views/listContent";		
		}
		service.save(c);
		AllContent(model);
		System.out.println("Contenido GUARDADO CON EXITO!!");
		messagesAtributte.addFlashAttribute("succes", "CONTENIDO GUARDADO CON EXITO");
		return "/views/listContent";
	}
	
	@GetMapping("/mc/{id}")
	public String editProducto(@PathVariable("id") Long idContent, Model model) {
		EContent c = new EContent();
		if(idContent>0) {
			c=service.findPorID(idContent);
			if(idContent!=null) { 
				model.addAttribute("titulo", c.getTitulo());
				model.addAttribute("contenido", c);				 	
			}
			else {
				System.out.println("ERROR!! EL id del contenido no existe!!!");
				return "/views/listContent";
			}
		}
		else {
			System.out.println("ERROR!! EL id del cliente es incorrecto!!!");
			return "/views/listContent";
		}		
		return "views/mostrarcontenido";
	}
	
	@GetMapping("/pr")
	public String pathPrueba(Model model) {
		EContent c = new EContent();
		model.addAttribute("titulo", "TITULO DE PRUEBA");
		model.addAttribute("contenido", c);
		return "/views/mostrarcontenido";	
	}
	
	@GetMapping("/delet/{id}")
	public String deleteContent(@PathVariable("id") Long idContenido, Model model) {
		//EVALUAR ESTA EXPRESION if (id.isPresent()) {
		if(idContenido!=null) {
			service.delete(idContenido);			
			System.out.println("CONTENIDO ELIMINADO CON EXITO!!"); 	
		}
		return "redirect:/views/listContent";
	}
	
	public void AllContent(Model model) {
		List<Content> allcontent = new ArrayList<Content>();
		allcontent = service.getAllContent();
		model.addAttribute("titulo", "Contenido");
		model.addAttribute("listadecontenidos", allcontent);
		System.out.println("OK!! Se listo el Contenido!!!");
	} 
	
	
}
