package com.web.model;

import java.util.Date;



import org.web.entity.EGastos;

public class Gastos {
	
	private Long id;
	 
	private String titulo;
	 
	private String descripcion;
	 
	private double montobs;
	 
	private double montodivisa;
	 
	private String categoria;
	 
	private Date fechagastos;
	
	private String mes;

	
	
	public Gastos(EGastos eg) {
		 
		this.id = eg.getId();
		this.titulo = eg.getTitulo();
		this.descripcion = eg.getDescripcion();
		this.montobs = eg.getMontobs();
		this.montodivisa = eg.getMontodivisa();
		this.categoria = eg.getCategoria();
		this.fechagastos = eg.getFechagastos();
		this.mes = eg.getMes();
	}



	public Gastos() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Gastos(Long id, String titulo, String descripcion, double montobs, double montodivisa, String categoria,
			Date fechagastos, String mes) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.montobs = montobs;
		this.montodivisa = montodivisa;
		this.categoria = categoria;
		this.fechagastos = fechagastos;
		this.mes = mes;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public double getMontobs() {
		return montobs;
	}



	public void setMontobs(double montobs) {
		this.montobs = montobs;
	}



	public double getMontodivisa() {
		return montodivisa;
	}



	public void setMontodivisa(double montodivisa) {
		this.montodivisa = montodivisa;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Date getFechagastos() {
		return fechagastos;
	}



	public void setFechagastos(Date fechagastos) {
		this.fechagastos = fechagastos;
	}



	public String getMes() {
		return mes;
	}



	public void setMes(String mes) {
		this.mes = mes;
	}
	
	
	

}
