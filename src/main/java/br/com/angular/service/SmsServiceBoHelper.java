package br.com.angular.service;

import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.exceptions.NegocioException;

public interface SmsServiceBoHelper {

	void validar(Sms sms) throws NegocioException;

	void validarCampos(Sms sms) throws NegocioException;

	void verificarDataValidade(Sms sms) throws NegocioException;

	void validarUsuario(Sms sms) throws NegocioException;

}
