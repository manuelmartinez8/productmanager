package com.web.model;

import java.io.Serializable;

import org.web.entity.EProduct;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descripcion;
	private int stock;
	private String categoria;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String descripcion, int stock, String categoria) {
		super();
		this.descripcion = descripcion;
		this.stock = stock;
		this.categoria = categoria;
	}
	
	


	public Product(EProduct ep) {
		super();
		this.id = ep.getId();
		this.descripcion = ep.getDescripcion();
		this.stock = ep.getStock();
		this.categoria = ep.getCategoria();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", descripcion=" + descripcion + ", stock=" + stock + ", categoria=" + categoria
				+ "]";
	}
	
	
	
	
}
