package com.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.web.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.converter.ProductConverter;
import org.web.entity.EProduct;

import com.web.model.Product;
import com.web.repository.ProductRepository;


@Service 
public class ProductServiceImpl implements IProductService {
	 
	private ProductRepository repository;
	private ProductConverter converter= new ProductConverter();
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
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
			if(Objects.nonNull(ep)){
			repository.save(ep);
			log.info("PROCESO DE GUARDADO DEL NUEVO PRODUCTO TERMINO CON EXITO");
			}
		}catch (Exception e){
			e.printStackTrace();
			log.error(e.getMessage(), "PROCESO DE GUARDADO DEL NUEVO PRODUCTO NO TERMINO CON EXITO");
		}
	}
	@Override
	public void Eliminar(Long id) {
		EProduct ep = findPorID(id);
		if(id!=null){
			EProduct p = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Producto no Encontrado", "id: "+id));
			repository.deleteById(id);
			log.info("PRODUCTO ELIMINADO DEL SISTEMA");
		}
	}
	@Override
	public EProduct findPorID(Long id) {
		if(id!=null) {
			EProduct p = repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Producto no Encontrado", "id: "+id));
			return p;
		}
		return  null;
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
