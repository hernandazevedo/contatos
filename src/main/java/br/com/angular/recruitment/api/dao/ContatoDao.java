package br.com.angular.recruitment.api.dao;

import java.util.List;

import br.com.angular.recruitment.api.entidades.Contato;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;

public interface ContatoDao {
	void salvar(Contato contato) throws PersistenciaException;
	List<Contato> listarTodos() throws PersistenciaException;
	Contato getContato(Long id) throws PersistenciaException;
}
