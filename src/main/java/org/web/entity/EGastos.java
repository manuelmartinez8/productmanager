package org.web.entity;

import com.web.model.Gastos;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
	@Column(name = "montoeuros")
	private double montoeuros;
	@Column(name = "categoria")
	private String categoria;
	private LocalDate fechagastos;

	public EGastos(Gastos g) {
		this.titulo = g.getTitulo();
		this.descripcion = g.getDescripcion();
		this.montoeuros = g.getMontoeuros();
		this.categoria = g.getCategoria();
		this.fechagastos = LocalDate.parse(g.getFechagastos());
	}
}
	
	
	
	
	
	
	
	
	

