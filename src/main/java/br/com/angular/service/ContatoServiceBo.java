package br.com.angular.service;

import java.util.List;

import br.com.angular.recruitment.api.bean.ContatoBean;
import br.com.angular.recruitment.api.exceptions.NegocioException;

public interface ContatoServiceBo{


	void salvar(ContatoBean contato) throws NegocioException;

	List<ContatoBean> listarTodos() throws NegocioException;
	
	ContatoBean getContato(Long id) throws NegocioException;
	

}
