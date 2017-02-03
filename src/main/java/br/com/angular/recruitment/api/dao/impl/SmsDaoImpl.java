package br.com.angular.recruitment.api.dao.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.angular.recruitment.api.dao.SmsDao;
import br.com.angular.recruitment.api.entidades.Sms;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;

/**
 * Classe responsavel pela gravacao do sms no banco de dados
 * @author Hernand Azevedo
 *
 */
@Repository
public class SmsDaoImpl implements SmsDao{

	private Logger logger = Logger.getLogger(SmsDaoImpl.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Sms sms) throws PersistenciaException {
		try{
			entityManager.persist(sms);
			entityManager.flush();
		}catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new PersistenciaException("Erro ao gravar o sms");
			
		}
	}

	@Override
	public List<br.com.angular.recruitment.api.entidades.Sms> findAll() {
		try{
			return entityManager.createQuery("from Sms", Sms.class).getResultList();
		}catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new PersistenciaException("Erro ao gravar o sms");
			
		}
	}

}
