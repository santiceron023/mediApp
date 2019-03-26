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
import com.mitocode.model.Consulta;
import com.mitocode.service.IConsultaService;



@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private IConsultaService servicio;
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@RequestBody Consulta cons) {
		Consulta consulta = new Consulta();
		consulta = servicio.registrar(cons);
		
		// constriur la ruta pacientes/id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cons.getIdConsulta()).toUri();
		
		//esatdo created(201)
		return ResponseEntity.created(location).build();
		
		
		
	}
	
//	@GetMapping
//	public List<consulta> listar(){
//		return servicio.listar();
//	}
//	
//	@PutMapping
//	public consulta modificar(@RequestBody consulta cons){
//		return servicio.modificar(cons);
////		consulta cons = servicio.  
////		return ResponseEntity<consulta>(cons,HttpStatus.)
//	}
////	
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<consulta> listarPorId(@PathVariable("id") Integer id){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
//		
//		consulta cons = servicio.listarPorId(id);
//		if(cons == null) {
//			throw new ModeloNotFoudException("Id no econtrado " + id);
//		}
////		return servicio.listarPorId(id);
//		return new ResponseEntity<consulta>(cons,HttpStatus.OK);
//	}
//	
//	@DeleteMapping(value = "/{id}")
//	public void eliminarPorId(@PathVariable("id") Integer id){
//		consulta cons = servicio.listarPorId(id);
//		if(cons == null) {
//			throw new ModeloNotFoudException("Id no econtrado " + id);
//		}else {
//		servicio.eliminar(id);
////		return servicio.listarPorId(id);
////		return new ResponseEntity<consulta>(cons,HttpStatus.OK);
//	    }
//	}
	
}
