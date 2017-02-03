package br.com.angular.recruitment.api.dao;

import java.util.List;

import br.com.angular.recruitment.api.entidades.Operadora;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;

public interface OperadoraDao {
	List<Operadora> listarTodos() throws PersistenciaException;
}
