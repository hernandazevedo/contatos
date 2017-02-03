package br.com.angular.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angular.recruitment.api.bean.ContatoBean;
import br.com.angular.recruitment.api.bean.OperadoraBean;
import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.converters.OperadoraConverter;
import br.com.angular.recruitment.api.dao.OperadoraDao;
import br.com.angular.recruitment.api.entidades.Contato;
import br.com.angular.recruitment.api.entidades.Operadora;
import br.com.angular.recruitment.api.enums.ResponsesEnum;
import br.com.angular.recruitment.api.exceptions.NegocioException;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;
import br.com.angular.service.OperadoraServiceBo;

/**
 * Classe Mock do envio de sms da operadora
 * @author Hernand Azevedo
 *
 */
@Service
public class OperadoraServiceBoImpl implements OperadoraServiceBo{

	Logger logger = Logger.getLogger(OperadoraServiceBoImpl.class.getName());
	
	@Autowired
	private OperadoraDao operadoraDao;
	
	@Override
	public void send(Sms sms) throws NegocioException {

		logger.log(Level.INFO, "---- MOCK ---- Enviando sms ---- MOCK ---- ");
		//TODO implementar abaixo com a api da operadora
		
		/**
		 * 
		 * Para futura, a lógica de envio do SMS real para a operadora está fora do escopo deste projeto.
		 * Escrever aqui o código que envia o sms.
		 */
	}
	
	@Override
	public List<OperadoraBean> listarTodos() throws NegocioException{


		logger.log(Level.INFO, "listar contatos ");
		List<OperadoraBean> contatosRetorno = new ArrayList<OperadoraBean>();
		try{
			List<Operadora> operadoras = operadoraDao.listarTodos();
			
			if(operadoras != null && !operadoras.isEmpty()){
				for(Operadora c : operadoras){
			
					contatosRetorno.add(OperadoraConverter.convert(c));
				}
			
			}
			
		}
		catch (PersistenciaException e) {
			String message = "Erro listar operadoras";
			logger.log(Level.SEVERE, "Erro ao listar operadoras no banco ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR,message);			
		}
		catch (NegocioException e) {
			throw e;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Erro não esperado ao listar operadoras ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR);
		}
		
		return contatosRetorno;
	}

}
