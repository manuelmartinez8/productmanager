package com.web.model;

import java.time.LocalDate;
import java.util.Date;


import lombok.*;
import org.web.entity.EGastos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Gastos {
	
	private Long id;
	@NotEmpty
	private String titulo;
	@NotEmpty
	private String descripcion;
	@NotNull
	private double montoeuros;
	@NotEmpty
	private String categoria;
	@NotEmpty
	private String fechagastos;

	public Gastos(EGastos eg) {
		this.id =eg.getId();
		this.titulo = eg.getTitulo();
		this.descripcion = eg.getDescripcion();
		this.montoeuros = eg.getMontoeuros();
		this.categoria = eg.getCategoria();
		this.fechagastos = eg.getFechagastos().toString();

	}

}
