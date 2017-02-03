package br.com.angular.recruitment.api.dao;

import java.util.List;

import br.com.angular.recruitment.api.entidades.Sms;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;

public interface SmsDao {
	void save(Sms sms) throws PersistenciaException;

	List<br.com.angular.recruitment.api.entidades.Sms> findAll();
}
