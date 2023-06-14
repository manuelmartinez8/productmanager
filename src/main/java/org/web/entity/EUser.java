package org.web.entity;

import com.web.model.Orden;
import com.web.model.Product;

import java.io.Serializable;
//import java.sql.Date;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="usuarios")
public class EUser implements Serializable{

    private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre",   length = 150)
	private String nombre;
	
	private int documento;
	
	private String email;
	
	private String password;
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@OneToMany(mappedBy = "usuario")
	private List<EProduct> productoList;

	@OneToMany(mappedBy = "usuario")
	private List<EOrden> ordenes;

	public EUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EUser(Long id, String nombre, int documento, String email, String password, Date fechaNacimiento) {
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

	
}
