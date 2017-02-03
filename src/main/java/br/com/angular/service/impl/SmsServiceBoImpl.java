package br.com.angular.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.converters.SmsConverter;
import br.com.angular.recruitment.api.dao.SmsDao;
import br.com.angular.recruitment.api.enums.ResponsesEnum;
import br.com.angular.recruitment.api.exceptions.NegocioException;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;
import br.com.angular.service.OperadoraServiceBo;
import br.com.angular.service.SmsServiceBo;
import br.com.angular.service.SmsServiceBoHelper;


/**
 * Esta é classe de negocio responsavel por tratar o envio de sms. 
 * @author Hernand Azevedo
 *
 */
@Service
public class SmsServiceBoImpl implements SmsServiceBo {
	
	

	/** 
	 * Classe reponsavel por tratar o salvamento do sms no banco
	 */
	@Autowired
	private SmsDao smsDao;
	
	/**
	 * Classe responsavel pela implementacao da API de envio da Operadora. Esta mockado
	 */
	@Autowired
	private OperadoraServiceBo operadoraSmsServiceBo;
	
	
	/**
	 * Classe onde se concentram as regras de validacao do servico
	 */
	@Autowired
	private SmsServiceBoHelper smsServiceBoHelper;
	
	private Logger logger = Logger.getLogger(OperadoraServiceBoImpl.class.getName());

	@Transactional
	@Override
	public void enviar(Sms sms) throws NegocioException {

		try{
			logger.log(Level.INFO, "Enviando o sms"+sms);
			
			//Realiza as regras de validacao no sms
			smsServiceBoHelper.validar(sms);
		
			//Enviando para o mock da operadora
			operadoraSmsServiceBo.send(sms);
			
			//Grava no banco o registro enviado
			br.com.angular.recruitment.api.entidades.Sms entidade = SmsConverter.convert(sms);
			
			entidade.setDataEnvio(new Date());
			smsDao.save(entidade);
			
		}
		catch (PersistenciaException e) {
			String message = "Erro ao gravar o sms no banco";
			logger.log(Level.SEVERE, "Erro ao gravar o sms no banco ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR,message);			
		}
		catch (NegocioException e) {
			throw e;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Erro não esperado ao enviar sms ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR);
		}

	}

	

	@Transactional
	@Override
	public List<Sms> listarTodos() throws NegocioException {

		logger.log(Level.INFO, "Listando todos os SMS");
		List<Sms> listaRetorno = new ArrayList<Sms>();
		try{
			List<br.com.angular.recruitment.api.entidades.Sms> lista = smsDao.findAll();
			
			if(lista != null && !lista.isEmpty()){
				for(br.com.angular.recruitment.api.entidades.Sms sms :lista){
					Sms bean = SmsConverter.convert(sms);
					listaRetorno.add(bean);
				}
			}
			
			
			return listaRetorno;
		}
		catch (PersistenciaException e) {
			String message = "Erro ao gravar o sms no banco";
			logger.log(Level.SEVERE, "Erro ao gravar o sms no banco ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR,message);			
		}
		catch (NegocioException e) {
			throw e;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Erro não esperado ao enviar sms ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR);
		}

		
	}

	

}