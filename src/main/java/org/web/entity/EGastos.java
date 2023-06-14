package org.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="gastos")
public class EGastos implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo",   length = 100)
	private String titulo;
	@Column(name = "descripcion",   length = 200)
	private String descripcion;
	@Column(name = "montobs")
	private double montobs;
	@Column(name = "montodivisa")
	private double montodivisa;
	@Column(name = "categoria")
	private String categoria;
	@Temporal(TemporalType.DATE)
	private Date fechagastos;	 
	private String mes;
	
	
	
	public EGastos() {
		super();
	}
	
	public EGastos(Long id, String titulo, String descripcion, double montobs, double montodivisa, String categoria,
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
