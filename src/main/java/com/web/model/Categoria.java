package com.web.model;

import org.web.entity.ECategoria;

public class Categoria {
	
	private Long id;
	
	private String categoria;
	
	public Categoria(ECategoria ec) {		 
		this.id = ec.getId();
		this.categoria = ec.getCategoria();
	}
	
	

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(Long id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
