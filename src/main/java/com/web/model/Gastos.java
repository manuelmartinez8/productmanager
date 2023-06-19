package com.web.model;

import java.time.LocalDate;
import java.util.Date;


import lombok.*;
import org.web.entity.EGastos;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Gastos {
	

	private String titulo;
	private String descripcion;
	private double montoeuros;
	private String categoria;
	private String fechagastos;

	public Gastos(EGastos eg) {

		this.titulo = eg.getTitulo();
		this.descripcion = eg.getDescripcion();
		this.montoeuros = eg.getMontoeuros();
		this.categoria = eg.getCategoria();
		this.fechagastos = eg.getFechagastos().toString();

	}

}
