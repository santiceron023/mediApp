package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.DAO.IConsultaDao;
import com.mitocode.model.Consulta;
import com.mitocode.service.IConsultaService;


@Service
public class ConsultaServiceImpl implements IConsultaService{
	
	@Autowired
	IConsultaDao dao;
 
	
	@Override
	public Consulta registrar(Consulta cons) {
		// TODO Auto-generated method stub
		cons.getDetalleConsulta().forEach(detalle -> detalle.setConsulta(cons));
		return dao.save(cons);
	}

	@Override
	public Consulta modificar(Consulta t) {
		
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Consulta> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulta listarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
