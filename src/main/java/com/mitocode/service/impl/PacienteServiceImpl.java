package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.DAO.IPacienteDAO;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{
	
	
	@Autowired
	private IPacienteDAO dao;

	@Override
	public Paciente registrar(Paciente t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.delete(id);
		
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Paciente listarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}
