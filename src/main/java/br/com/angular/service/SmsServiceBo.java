package br.com.angular.service;

import java.util.List;

import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.exceptions.NegocioException;

public interface SmsServiceBo{
 
	void enviar(Sms sms)throws NegocioException ;

	List<Sms> listarTodos() throws NegocioException;
 
}