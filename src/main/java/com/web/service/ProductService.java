package com.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.web.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.converter.ProductConverter;
import org.web.entity.EProduct;

import com.web.model.Product;
import com.web.repository.ProductRepository;


@Service 
public class ProductService  implements IProductService {
	
	 
	private ProductRepository repository;
	private ProductConverter converter= new ProductConverter();
	private static final Logger log = LoggerFactory.getLogger(ProductService.class);
	@Autowired	
	public void setProductRepository(ProductRepository repository) {
		this.repository=repository;
	}
 
	@Transactional
	@Override
	public List<Product> getAllProduct() {
		List<Product> lp = new ArrayList<Product>();
		try {
			lp=this.converter.convertirProducto(repository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  lp;
	}

	@Override
	public void guardar(EProduct ep) {
		try {
			repository.save(ep);
			log.info("PROCESO DE GUARDADO DEL NUEVO PRODUCTO TERMINO CON EXITO");
		}catch (Exception e){
			e.printStackTrace();
			log.error(e.getMessage(), "PROCESO DE GUARDADO DEL NUEVO PRODUCTO NO TERMINO CON EXITO");

		}

	}



	@Override
	public  Product buscarPorID(Long id) { 
		 
		try {
			System.out.println("EL VALOR DE ID ES" + id);
			Product p= new Product(repository.findById(id).orElse(null));
			 return p;
					 //converter.convertirUnProducto(repository.findById(id).orElse(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return   null; 
				 
	}



	@Override
	public void Eliminar(Long id) {
		repository.deleteById(id);
		
	}



	@Override
	public EProduct findPorID(Long id) {
		EProduct p = new EProduct();
		if(id!=null) { 
			p= repository.findById(id)
					.orElseThrow(() ->new ResourceNotFoundException("Producto no Encontrado", "id: "+id));
		}
		return p;
	}
	
//	public Product getProducto(Long id) {
//		Product p = new Product();
//		
//		try {
//			Optional<Product> op=repository.findById(id);
//			if(op.isPresent()) {
//				p=op.get();				
//			}
//			else {
//				return null;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return p;
//	}

}
