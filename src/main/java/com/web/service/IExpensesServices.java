package com.web.service;

import java.util.List;

import org.web.entity.EGastos;

import com.web.model.CategoriasProductosEnum;
import com.web.model.Gastos;
import com.web.model.GastosEnum;
 

public interface IExpensesServices {
	
	List<Gastos> getAllGastos();
	public void guardar(EGastos e);
	public   Gastos buscarPorID(Long id);
	public   EGastos findPorID(Long id);
	public void Eliminar(Long id);
	List<GastosEnum>ListaGastosEnum(); 

}
