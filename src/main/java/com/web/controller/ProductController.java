package com.web.controller;

import java.util.List;

import javax.validation.Valid;


import com.web.util.ConstantsUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.web.entity.EProduct;

import com.web.model.CategoriasProductosEnum;
import com.web.model.Product;
import com.web.service.ICategoriaService;
import com.web.service.IProductService;

@Tag(name = "Product", description = "Product management APIs")
@Controller
@RequestMapping("/views/")
public class ProductController {
	
	@Autowired
	private IProductService service;
	@Autowired
	private ICategoriaService categoriaService;
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	ConstantsUtil constantsUtil = new ConstantsUtil();
	@Operation(
			summary = "Retrieve a list of all product",
			description = "Get a list of all product  object by specifying.",
			tags = { "product", "get" })
	@RequestMapping("listProduct")
	public String getProducts(Model model) {
		List<Product> allProduct = service.getAllProduct();
		model.addAttribute("titulo", "Los Productos");
		model.addAttribute("listadeproductos", allProduct);
		return constantsUtil.VIEW_LISTADO_PRODUCTOS;
	}

	@Operation(
			summary = "Form to save a new product",
			description = "Form to save a new product, set title, kind and category.",
			tags = { "product", "get" })
	@GetMapping("fnewproduct")
	public String nuevoProducto(Model model) {
		buildModel(null, "Formulario Nuevo Producto", model);
		return constantsUtil.FORMULARIO_NUEVO_PRODUCTO;
	}

	@Operation(
			summary = "Endpoint to save a new product",
			description = "Endpoint to save a new product, set title, kind and category.",
			tags = { "product", "post" })
	@PostMapping("/saveproduct")
	public String Guardar(@Valid @ModelAttribute EProduct productoNuevo,
			BindingResult result, Model model,
			RedirectAttributes messagesAtributte) {
		List<CategoriasProductosEnum> listaCategorias= categoriaService.ListaCategoriasEnum();
		//docuemntar esta validacion
		if(result.hasErrors()) {
			buildModel(null,"Formulario Nuevo Producto Con errores", model);
			messagesAtributte.addAttribute("warning", result.getAllErrors().toString());
			messagesAtributte.addFlashAttribute("warning", "DEBE RELLENAR TODOS LOS CAMPOS");
			log.error("ESTA VACIO EL OBJETO");
			return constantsUtil.FORMULARIO_NUEVO_PRODUCTO;
		}
		service.guardar(productoNuevo);
		messagesAtributte.addFlashAttribute("succes", "PRODUCTO GUARDADO CON EXITO");
		return constantsUtil.REDIRECT_LISTADO_PRODUCTOS;
	}
	
	@GetMapping("/edit/{id}")
	public String editProducto(@PathVariable("id") Long idProducto, Model model) {
		if(idProducto>0) {
			buildModel(idProducto,"Formulario Editar Producto", model);
		}
		return constantsUtil.FORMULARIO_NUEVO_PRODUCTO;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProducto(@PathVariable("id") Long idProducto, Model model) {
		if(idProducto!=null) {		//retornar un mensaje acorde si el producto no existe en la BD
			service.Eliminar(idProducto);
		}
		return constantsUtil.REDIRECT_LISTADO_PRODUCTOS;
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
	private Model buildModel(Long id, String titulo,Model model){
		EProduct ep = new EProduct();
		if(id!=null)
		{
			ep = service.findPorID(id);
		}
		List<CategoriasProductosEnum> lc= categoriaService.ListaCategoriasEnum();
		model.addAttribute("titulo", titulo);
		model.addAttribute("producto", ep);
		model.addAttribute("categorias", lc);
		return model;
	}
}
