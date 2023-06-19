package com.web.service;

import java.util.ArrayList;
import java.util.List;

import com.web.controller.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.converter.GastosConverter;
import org.web.entity.EGastos;

import com.web.model.Gastos;
import com.web.model.GastosEnum;
import com.web.repository.GastosRepository;


@Service
public class ExpensesServices implements IExpensesServices {
	
	private GastosRepository repository;
	private GastosConverter converter= new GastosConverter();
	private GastosEnum enums;
	private static final Logger log = LoggerFactory.getLogger(ExpensesServices.class);
	@Autowired
	public void setGastosRepository(GastosRepository repository) {
		this.repository=repository;
	}

	@Override
	public List<Gastos> getAllGastos() {
		 List<Gastos>list=new ArrayList<Gastos>();
		 try {
			list=this.converter.convertirGastos(repository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return list;
	}

	@Override
	public void guardar(EGastos e) {		
		try {
			repository.save(e);
			log.info("PROCESO DE GUARDADO DEL NUEVO GASTO TERMINO CON EXITO");
		} catch (Exception eX) {
			eX.printStackTrace();
			log.error(eX.getMessage(), "PROCESO DE GUARDADO DEL NUEVO GASTO NO TERMINO CON EXITO");
		}
	}

	@Override
	public Gastos buscarPorID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EGastos findPorID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GastosEnum> ListaGastosEnum() {
		List<GastosEnum> list=new ArrayList<GastosEnum>();
		list.add(enums.BEBIDA);
		list.add(enums.CARRO);
		list.add(enums.COMIDA);
		list.add(enums.CALZADOS);
		list.add(enums.DOCUMENTACION);
		list.add(enums.EMPRENDIMIENTO);
		list.add(enums.FOODY);
		list.add(enums.GASTO);
		list.add(enums.SERVICIOS);
		list.add(enums.OTRO);
		list.add(enums.ROPA);
		return list;
	}

}
