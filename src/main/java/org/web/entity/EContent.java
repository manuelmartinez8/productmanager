package org.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conten")
public class EContent implements Serializable{

private static final long serialVersionUID = 1L;	
 

	@Id
	@Column(name = "id")	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	private String titulo;	
	private String contenido;
	private String contenido2;
	private String contenido3;
	private String contenido4;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	
	
	private String categoria;
	
	private String fuente;

	public EContent() {
		super();		 
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

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFuente() {
		return fuente;
	}
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	public String getContenido2() {
		return contenido2;
	}
	public void setContenido2(String contenido2) {
		this.contenido2 = contenido2;
	}
	public String getContenido3() {
		return contenido3;
	}
	public void setContenido3(String contenido3) {
		this.contenido3 = contenido3;
	}
	public String getContenido4() {
		return contenido4;
	}
	public void setContenido4(String contenido4) {
		this.contenido4 = contenido4;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	
	

}
