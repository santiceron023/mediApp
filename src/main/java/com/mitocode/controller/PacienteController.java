package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoudException;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService servicio;
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> registrar(@RequestBody Paciente pac) {
		Paciente paciente = new Paciente();
		paciente = servicio.registrar(pac);
		
		// constriur la ruta pacientes/id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdPaciente()).toUri();
		
		//esatdo created(201)
		return ResponseEntity.created(location).build();
		
		
		
	}
	
	@GetMapping
	public List<Paciente> listar(){
		return servicio.listar();
	}
	
	@PutMapping
	public Paciente modificar(@RequestBody Paciente pac){
		return servicio.modificar(pac);
//		Paciente pac = servicio.  
//		return ResponseEntity<Paciente>(pac,HttpStatus.)
	}
//	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		
		Paciente pac = servicio.listarPorId(id);
		if(pac == null) {
			throw new ModeloNotFoudException("Id no econtrado " + id);
		}
//		return servicio.listarPorId(id);
		return new ResponseEntity<Paciente>(pac,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminarPorId(@PathVariable("id") Integer id){
		Paciente pac = servicio.listarPorId(id);
		if(pac == null) {
			throw new ModeloNotFoudException("Id no econtrado " + id);
		}else {
		servicio.eliminar(id);
//		return servicio.listarPorId(id);
//		return new ResponseEntity<Paciente>(pac,HttpStatus.OK);
	    }
	}
}
