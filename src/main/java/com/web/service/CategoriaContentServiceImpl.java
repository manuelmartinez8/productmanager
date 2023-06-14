package com.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Categoria;
import com.web.model.CategoriasContenidoEnum;
import com.web.model.CategoriasProductosEnum;
import com.web.repository.CategoriaRepository;
import com.web.repository.ContenRepository;

@Service
public class CategoriaContentServiceImpl implements ICategoriasContent {

	
	@Autowired
	private ContenRepository contenRepository;
	CategoriasContenidoEnum cat;
	
	@Override
	public List<Categoria> ListaCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriasContenidoEnum> ListaCategoriasEnum() {
		List<CategoriasContenidoEnum> list = new ArrayList<CategoriasContenidoEnum>();
		 
		 list.add(cat.DOCUMENTACION);
		 list.add(cat.HIBERNATE);
		 list.add(cat.GIT);
		 list.add(cat.JAVA);
		 list.add(cat.JPA);
		 list.add(cat.MYSQL );
		 list.add(cat.SPRING);
		 list.add(cat.SPRINGBOOT);
		 list.add(cat.SCRUM);
		 list.add(cat.UML );
		 list.add(cat.WEBSERVICE);
		 list.add(cat.PATRON_DE_DISENIOO);
		 
		return list;
	}

}
