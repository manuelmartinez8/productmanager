package org.web.converter;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.stereotype.Component;
import org.web.entity.EProduct;

import com.web.model.Product;

@Component 
public class ProductConverter  {
	
	public List<Product> convertirProducto(List<EProduct> productos){
		List<Product> modelProducto= new ArrayList<>();
		
		for(EProduct ep: productos) {
			modelProducto.add(new Product(ep));
		}	
		
		return modelProducto;
	}
	
	
	public Product convertirUnProducto(EProduct ep) {
		Product p = new Product(ep);
		return  p;
	}
	

}
