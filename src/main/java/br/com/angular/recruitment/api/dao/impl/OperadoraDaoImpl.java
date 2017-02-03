package br.com.angular.recruitment.api.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.angular.recruitment.api.dao.OperadoraDao;
import br.com.angular.recruitment.api.entidades.Operadora;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;

@Repository
public class OperadoraDaoImpl implements OperadoraDao,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Logger logger = Logger.getLogger(SmsDaoImpl.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public List<Operadora> listarTodos() throws PersistenciaException {

		try{
			return entityManager.createQuery("from Operadora",Operadora.class).getResultList();
		}catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new PersistenciaException("Erro ao listar os contatos");
			
		}
	}

}
