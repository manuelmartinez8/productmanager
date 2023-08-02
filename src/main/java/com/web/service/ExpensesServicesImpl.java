package com.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.web.exception.ResourceNotFoundException;
import com.web.model.MesesEnum;
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
public class ExpensesServicesImpl implements IExpensesServices {
	
	private GastosRepository repository;
	private GastosConverter converter= new GastosConverter();
	private GastosEnum enums;

	private static final Logger log = LoggerFactory.getLogger(ExpensesServicesImpl.class);
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

	public List<Gastos> getGastosForMes(String mes){
		List<Gastos> listado = getAllGastos();
		List<Gastos> list = new ArrayList<>();
		try {
			  list = listado.stream()
					.filter(gastos -> gastos.getMes().equals(mes))
					.collect(Collectors.toList());
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return list;
	}

	@Override
	public void guardar(EGastos e) {		
		try {
			if(Objects.nonNull(e)){
				repository.save(e);
				log.info("PROCESO DE GUARDADO DEL NUEVO GASTO TERMINO CON EXITO");
			}else{
				log.error("DEBE RELLENAR TODOS LOS CAMPOS");
			}
		} catch (Exception eX) {
			eX.printStackTrace();
			log.error(eX.getMessage(), "PROCESO DE GUARDADO DEL NUEVO GASTO NO TERMINO CON EXITO");
		}
	}
	@Override
	public EGastos findPorID(Long id) {
		EGastos eg = new EGastos();
		if (id!=null){
			eg = repository.findById(id)
					.orElseThrow(() ->new ResourceNotFoundException("El id  no se Encuentra en el Sistema", "id:" + id));
		}
		return eg;
	}
	@Override
	public void Eliminar(Long id) {
		  if(id!=null){
			 // EGastos eg = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Gasto no Encontrado", "id: "+id));
			  repository.deleteById(id);
			  log.info("PROCESO DE BORRADO DEL NUEVO GASTO TERMINO CON EXITO");
		  }
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

	@Override
	public List<MesesEnum> ListaMesesEnum() {
		List<MesesEnum> lista = new ArrayList<>();
		lista.add(MesesEnum.ENERO);
		lista.add(MesesEnum.FEBRERO);
		lista.add(MesesEnum.MARZO);
		lista.add(MesesEnum.ABRIL);
		lista.add(MesesEnum.MAYO);
		lista.add(MesesEnum.JUNIO);
		lista.add(MesesEnum.JULIO);
		lista.add(MesesEnum.AGOSTO);
		lista.add(MesesEnum.SEPTIEMBRE);
		lista.add(MesesEnum.OCTUBRE);
		lista.add(MesesEnum.NOVIEMBRE);
		lista.add(MesesEnum.DICIEMBRE);

		return lista;
	}

}
