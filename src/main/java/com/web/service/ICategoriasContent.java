package com.web.service;

import java.util.List;

import com.web.model.Categoria;
import com.web.model.CategoriasContenidoEnum;
import com.web.model.CategoriasProductosEnum;

public interface ICategoriasContent {

	List<Categoria> ListaCategorias();
	List<CategoriasContenidoEnum>ListaCategoriasEnum(); 
}
