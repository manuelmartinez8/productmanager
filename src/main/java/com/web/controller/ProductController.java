package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.web.converter.ProductConverter;
import org.web.entity.EProduct;

import com.web.model.Categoria;
import com.web.model.CategoriasProductosEnum;
import com.web.model.Product;
import com.web.service.ICategoriaService;
import com.web.service.IProductService;
import com.web.service.ProductService;

@Controller
@RequestMapping("/views/")
public class ProductController {
	
	@Autowired
	IProductService service;
	@Autowired
	ICategoriaService categoriaService;
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping("listProduct")
	public String getProducts(Model model) {
		List<Product> allProduct = service.getAllProduct();
		model.addAttribute("titulo", "Los Productos");
		model.addAttribute("listadeproductos", allProduct);
		return "/views/listProduct";
	}
	
	
	@GetMapping("np")//cambiar este path
	public String nuevoProducto(Model model) {
		Product p = new Product();
		List<CategoriasProductosEnum> lc= categoriaService.ListaCategoriasEnum();
		p.setId(Long.valueOf(1));
		model.addAttribute("titulo", "Formulario Nuevo Producto");
		model.addAttribute("producto", p);
		model.addAttribute("categorias", lc);
		return "/views/frmnuevoproducto";
	}
	
	@PostMapping("/saveproduct")
	public String Guardar(@Valid @ModelAttribute EProduct p,
			BindingResult result, Model model,
			RedirectAttributes messagesAtributte) {
		List<CategoriasProductosEnum> lc= categoriaService.ListaCategoriasEnum();
		//docuemntar esta validacion
		if(result.hasErrors()) {			
			model.addAttribute("titulo", "Formulario Nuevo Producto");
			//model.addAttribute("SUBtitulo", "Formulario Nuevo Producto");
			model.addAttribute("producto", p);
			model.addAttribute("categorias", lc);
			System.out.println("DEBE CARGAR TODOS LOS DATOS!!");//quitar este systemnout
			
			return "/views/frmnuevoproducto";
		}
		
		service.guardar(p);
		System.out.println("PRODUCTO GUARDADO CON EXITO!!");//quitar este systemnout
		messagesAtributte.addFlashAttribute("succes", "PRODUCTO GUARDADO CON EXITO");
		return "redirect:/views/listProduct";
	}
	
	@GetMapping("/edit/{id}")
	public String editProducto(@PathVariable("id") Long idProducto, Model model) {
		EProduct p = new EProduct();
		if(idProducto>0) {
			p=service.findPorID(idProducto);
			if(idProducto!=null) {
				List<CategoriasProductosEnum> lc= categoriaService.ListaCategoriasEnum();
				model.addAttribute("titulo", "Formulario Editar Producto");
				model.addAttribute("producto", p);
				model.addAttribute("categorias", lc);	
			}
			else {
				System.out.println("ERROR!! EL id del cliente no existe!!!");
				return "redirect:/views/listProduct";
			}
		}
		else {
			System.out.println("ERROR!! EL id del cliente es incorrecto!!!");
			return "redirect:/views/listProduct";
		}
		return "/views/frmnuevoproducto";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProducto(@PathVariable("id") Long idProducto, Model model) {
		if(idProducto!=null) {		//validar primero que el producto exista
			service.Eliminar(idProducto);			
			System.out.println("PRODUCTO ELIMINADO CON EXITO!!"); 	
		}
		return "redirect:/views/listProduct";
	}
	
	
//	EL TIPO ResponseEntityPERMITE RETORNAR EL COLECTION CONLOS DATOS PERO TE PERMITE INCORPORAR EL HEADER Y    EL STATUS CODE
	@GetMapping("p")
	public ResponseEntity<List<Product>> getAll(){
		 List<Product> lp= service.getAllProduct();
	    if (lp == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(lp);
	    }
	}
	
	//PRODUCE EL JSON MEJOR FORMATEADO, 
	//LA ANOTACION @ResponseBody PERMITE RETORNAR EL COLECTION CONLOS DATOS PERO SPRING LE AGREGA EL HEADER Y EL STATUS CODE
	@RequestMapping(path = "/getproducts", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Product> findProduct() {
		List<Product> lp= service.getAllProduct();
		log.info("RETORNO LA LISTA DE PRODUCTOS");
        return lp;
    }
 	@PostMapping(value= "npr",
 			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
 	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
 	public ResponseEntity<EProduct> create(@RequestBody EProduct request){
 		EProduct ep=  request;
 		service.guardar(ep); 
		return ResponseEntity.ok(ep);
	}
 	
 	@RequestMapping(value = "s",method = RequestMethod.POST)     // or user @PostMapping
    public ResponseEntity<EProduct> save( @RequestBody EProduct ep){
 		if (ep == null) {
 			log.info("EL PRODUCTO LLEGO VACIO");
	        return ResponseEntity.notFound().build();
	    } else {
	    	 service.guardar(ep); 
	        return ResponseEntity.ok(ep);
	    }
 	    
    }

}
