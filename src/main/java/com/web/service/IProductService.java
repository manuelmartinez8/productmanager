package com.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.web.entity.EProduct;

import com.web.model.Product;

 
public interface IProductService {

	List<Product> getAllProduct();
	public void guardar(EProduct ep);
	public   EProduct findPorID(Long id);
	public void Eliminar(Long id);

	
}
