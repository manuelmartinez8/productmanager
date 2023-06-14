package com.web.service;

import java.util.List;
import com.web.model.Categoria;
import com.web.model.CategoriasProductosEnum;

public interface ICategoriaService {
	
	List<Categoria> ListaCategorias();
	List<CategoriasProductosEnum>ListaCategoriasEnum(); 

}
