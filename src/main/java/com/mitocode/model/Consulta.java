package com.mitocode.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdConsulta;

	@ManyToOne
	@JoinColumn(nullable = false, name = "id_paciente", foreignKey = @ForeignKey(name = "consulta_paciente"))
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(nullable = false, name = "id_medico", foreignKey = @ForeignKey(name = "consulta_medico"))
	private Medico medico;

	@ManyToOne
	@JoinColumn(nullable = false, name = "id_especialidad", foreignKey = @ForeignKey(name = "consulta_especialidad"))
	private Especialidad especialidad;

	// una consulta varios detalles
	@OneToMany(mappedBy = "consulta", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true) // CONSULTA ES EL MISMO DE DETALLE													// CONSULTA
	private List<DetalleConsulta> detalleConsulta;
	//	
	
	// Es para dar formato ISODate 2019-10-01T05:00:00.000
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha;

	
	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}

	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}

	public Integer getIdConsulta() {
		return IdConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		IdConsulta = idConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
