package org.web.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.web.entity.EGastos;
import com.web.model.Gastos;

@Component
public class GastosConverter {
	
	public List<Gastos> convertirGastos(List<EGastos> gastos){
		 List<Gastos>list=new ArrayList<Gastos>();
		 
		 for(EGastos e: gastos) {
			 list.add(new Gastos(e));
		 }
		
		return list;
		
	}

}
