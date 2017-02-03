package br.com.angular.service.impl;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.enums.ResponsesEnum;
import br.com.angular.recruitment.api.exceptions.NegocioException;
import br.com.angular.service.SmsServiceBoHelper;

/**
 * Classe responsavel por ajudar o SmsServicoBo com as regras de negocio
 * @author Hernand Azevedo
 *
 */
@Service
public class SmsServiceBoHelperImpl implements SmsServiceBoHelper {

	private Logger logger = Logger.getLogger(SmsServiceBoHelperImpl.class.getName());
	
	private static final int TAMANHO_MAXIMO_SMS = 160;
	
	/**
	 * Metodo responsavel por validar o sms
	 * @param sms
	 * @return
	 * @throws NegocioException
	 */
	@Override
	public void validar(Sms sms) throws NegocioException{

		validarCampos(sms);
		
		//Campo opcional. verificar se a data de validade nao expirou
		verificarDataValidade(sms);
		//Validar se o usuario existe 
		validarUsuario(sms);
		
	}

	/**
	 * Metodo que valida os campos obrigatorios do sms 
	 */
	@Override
	public void validarCampos(Sms sms)  throws NegocioException{
		String message = null;
		if(sms.getBody() == null || sms.getBody().trim().isEmpty()){
			message = "O body do sms nao pode ser vazio";
			logger.log(Level.SEVERE, message);
			throw new NegocioException(ResponsesEnum.VALIDATION_EXCEPTION,message);
		}
		
		if(sms.getBody().length() > TAMANHO_MAXIMO_SMS){
			message = MessageFormat.format("O tamanho maximo do sms nao deve ultrapassar {0} caracteres", TAMANHO_MAXIMO_SMS);
			logger.log(Level.SEVERE, message);
			throw new NegocioException(ResponsesEnum.VALIDATION_EXCEPTION,message);
		}
		
	}
	
	/**
	 * Metodo que verifica o campo de data de validade
	 */
	@Override
	public void verificarDataValidade(Sms sms) throws NegocioException {
		String message = null;
		//Campo opcional para validar
		if(sms.getValidade() != null && !sms.getValidade().isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			try {
				Date validade = sdf.parse(sms.getValidade());
				
				//verifica se ja passou da validade
				if(new Date().after(validade)){
					message = "Erro verificar a data de validade. SMS expirado";
					logger.log(Level.SEVERE, message);
					throw new NegocioException(ResponsesEnum.VALIDATION_EXCEPTION,message);					
				}
			} catch (Exception e) {
				message = "Erro parsear a data de validade favor utilizar o formado dd/MM/yyyy";
				logger.log(Level.SEVERE,message ,e);
				throw new NegocioException(ResponsesEnum.VALIDATION_EXCEPTION,message);
			}
			
		}
	}

	/**
	 * Metodo que avalia se o usuario é valido. 
	 * @param sms
	 */
	@Override
	public void validarUsuario(Sms sms)  throws NegocioException {
		
		//TODO avaliar a regra de negocio a mais que deve ser validada aqui
		
		String message = null;
		//Validando apenas obrigatoriedade por enquanto. 
		if(sms.getFrom() == null || sms.getFrom().isEmpty()){
			message = "From nao pode ser vazio";
			logger.log(Level.SEVERE, message );
			throw new NegocioException(ResponsesEnum.MOBILE_USER_NOT_FOUND,message );
		}
		
		if(sms.getTo() == null || sms.getTo().isEmpty()){
			message = "To nao pode ser vazio";
			logger.log(Level.SEVERE, message);
			throw new NegocioException(ResponsesEnum.MOBILE_USER_NOT_FOUND,message);
		}
		
		
	}
	
}
