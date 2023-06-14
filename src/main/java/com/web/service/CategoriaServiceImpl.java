package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.entity.ECategoria;

import com.web.model.Categoria;
import com.web.model.CategoriasProductosEnum;
import com.web.repository.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements ICategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	CategoriasProductosEnum cat;

	@Override
	public List<Categoria> ListaCategorias() {
		List<Categoria> list = new ArrayList<>();
		 
		for(ECategoria ec: categoriaRepository.findAll()) {
			list.add(new Categoria(ec));
		}
		return list;
	}

	@Override
	public List<CategoriasProductosEnum> ListaCategoriasEnum() {
		 List<CategoriasProductosEnum> list = new ArrayList<CategoriasProductosEnum>();
		 
		 list.add(cat.CERVECERIA);
		 list.add(cat.DOCUMENTACION);
		 list.add(cat.EMPRENDIMIENTO);
		 list.add(cat.FOODY);
		 list.add(cat.PROGRAMACION);
		 list.add(cat.WORKOUT);
		return list;
	}
	
 

}
