package br.com.angular.service;

import java.util.List;

import br.com.angular.recruitment.api.bean.OperadoraBean;
import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.exceptions.NegocioException;

public interface OperadoraServiceBo {

	void send(Sms sms) throws NegocioException ;
	
	List<OperadoraBean> listarTodos() throws NegocioException;
}
