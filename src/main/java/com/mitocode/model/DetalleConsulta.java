package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_consulta")
public class DetalleConsulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	
	// se va a llenar por medio de java en cosnulta service
	@JsonIgnore
	//varios detalles pueden pertenecer a una misma cpnsulta
	@ManyToOne
	@JoinColumn(name = "id_consulta" ,nullable = false, foreignKey = @ForeignKey(name = "detalle_consulta"))
	private Consulta consulta;  //CONSULTA ES EL MISMO DE DETALLE CONSULTA
	
	@Column(nullable = false, length = 88)
	private String diagnostico;
	
	@Column(nullable = false, length = 150)
	private String tratamiento;

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	

}
