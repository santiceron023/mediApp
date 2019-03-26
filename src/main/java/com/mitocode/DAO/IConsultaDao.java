package com.mitocode.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Consulta;

@Repository
public interface IConsultaDao extends JpaRepository<Consulta, Integer> {

}
