package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="paciente")
@ApiModel
public class Paciente {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@ApiModelProperty(value="maximo 50 caract")
	@Size(min=5,message= "no cumple el mínimo requerido")
	@Column(nullable = false, length = 150)
	private String direccion;
	
	
	@ApiModelProperty
	@Size(min=2,message= "no cumple el mínimo requerido")
	@Column(nullable = false, length = 8)
	private String dni;
	
	@Size(min=5,message= "no cumple el mínimo requerido")
	@Column(nullable = false, length = 70)
	private String nombres;
	
	@Size(min=5,message= "no cumple el mínimo requerido")
	@Column(nullable = false, length = 70)
	private String apellidos;
	
	@Size(min=5,message= "no cumple el mínimo requerido")
	@Column(nullable = false, length = 10)
	private String telefono;
	
	
	@Column(nullable = false, length = 55)
	private String email;
		
	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellido() {
		return apellidos;
	}
	public void setApellido(String apellido) {
		this.apellidos = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	

}
