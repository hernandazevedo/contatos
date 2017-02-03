package br.com.angular.recruitment.api.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.angular.recruitment.api.dao.ContatoDao;
import br.com.angular.recruitment.api.entidades.Contato;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;

@Repository
public class ContatoDaoImpl implements ContatoDao,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Logger logger = Logger.getLogger(SmsDaoImpl.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salvar(Contato contato) throws PersistenciaException {

		try{
			entityManager.merge(contato);
			entityManager.flush();
		}catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new PersistenciaException("Erro ao gravar o Contato"+contato);
			
		}
		
	}

	@Override
	public List<Contato> listarTodos() throws PersistenciaException {

		try{
			return entityManager.createQuery("from Contato",Contato.class).getResultList();
		}catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new PersistenciaException("Erro ao listar os contatos");
			
		}
	}
	
	@Override
	public Contato getContato(Long id) throws PersistenciaException {

		try{
			return entityManager.find(Contato.class,id);
		}catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new PersistenciaException("Erro ao listar os contatos");
			
		}
	}

	@Override
	public void deletarContato(Contato c) throws PersistenciaException {
		try{
			entityManager.remove(c);
		}catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new PersistenciaException("Erro ao listar os contatos");
			
		}
	}

}
