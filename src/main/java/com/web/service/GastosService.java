package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.web.converter.GastosConverter;
import org.web.entity.EGastos;

import com.web.model.Gastos;
import com.web.model.GastosEnum;
import com.web.repository.GastosRepository;


@Service
public class GastosService implements IGastosService {
	
	private GastosRepository repository;
	private GastosConverter converter= new GastosConverter();
	private GastosEnum enums;
	
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
		}
		return list;
	}

	@Override
	public void guardar(EGastos e) {		
		try {
			repository.save(e);
		} catch (Exception e2) {
			e2.printStackTrace();
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
		list.add(enums.DOCUMENTACION);
		list.add(enums.EMPRENDIMIENTO);
		list.add(enums.FOODY);
		list.add(enums.GASTO);
		list.add(enums.SERVICIOS);
		list.add(enums.OTRO);
		
		return list;
	}

}
