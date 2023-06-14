package com.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.web.entity.EUser;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;	
	 
	private String nombre;
	private int documento;
	private String email;
	private String password;
	private Date fechaNacimiento;

	
 

	public User(EUser u) {		 
		this.id = u.getId();
		this.nombre = u.getNombre();
		this.documento = u.getDocumento();
		this.email = u.getEmail();
		this.password = u.getPassword();
		this.fechaNacimiento = u.getFechaNacimiento();

	}

	public User() {
		super();		 
	}

	public User(Long id, String nombre, int documento, String email, String password, Date fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.documento = documento;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", documento=" + documento + ", email=" + email + ", password="
				+ password + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
	
}
