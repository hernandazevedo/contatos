package br.com.angular.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.angular.recruitment.api.bean.ContatoBean;
import br.com.angular.recruitment.api.converters.ContatoConverter;
import br.com.angular.recruitment.api.dao.ContatoDao;
import br.com.angular.recruitment.api.entidades.Contato;
import br.com.angular.recruitment.api.enums.ResponsesEnum;
import br.com.angular.recruitment.api.exceptions.NegocioException;
import br.com.angular.recruitment.api.exceptions.PersistenciaException;
import br.com.angular.service.ContatoServiceBo;

@Service
public class ContatoServiceBoImpl implements ContatoServiceBo {

	@Autowired
	private ContatoDao contatoDao;
	
	Logger logger = Logger.getLogger(ContatoServiceBoImpl.class.getName());
	
	@Override
	@Transactional
	public void salvar(ContatoBean contato) throws NegocioException {

		logger.log(Level.INFO, "salvar contato "+contato);
		try{
			Contato c = ContatoConverter.convert(contato);
			
			
			contatoDao.salvar(c);
		}
		catch (PersistenciaException e) {
			String message = "Erro ao gravar o contato no banco";
			logger.log(Level.SEVERE, "Erro ao gravar o contato no banco ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR,message);			
		}
		catch (NegocioException e) {
			throw e;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Erro nao esperado ao salvar contato ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR);
		}

		
	}
	@Override
	public List<ContatoBean> listarTodos() throws NegocioException{


		logger.log(Level.INFO, "listar contatos ");
		List<ContatoBean> contatosRetorno = new ArrayList<ContatoBean>();
		try{
			List<Contato> contatos = contatoDao.listarTodos();
			
			if(contatos != null && !contatos.isEmpty()){
				for(Contato c : contatos){
			
					contatosRetorno.add(ContatoConverter.convert(c));
				}
			
			}
			
		}
		catch (PersistenciaException e) {
			String message = "Erro ao gravar o contato no banco";
			logger.log(Level.SEVERE, "Erro ao gravar o contato no banco ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR,message);			
		}
		catch (NegocioException e) {
			throw e;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Erro não esperado ao salvar contato ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR);
		}
		
		return contatosRetorno;
	}
	
	@Override
	public ContatoBean getContato(Long id) throws NegocioException{


		logger.log(Level.INFO, "listar contatos ");
		ContatoBean contatoBean = null;
		try{
			Contato c = contatoDao.getContato(id);
			if(c != null){
				contatoBean = ContatoConverter.convert(c);
			}else{

				throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR,"Contato nao encontrado");
			}
		}
		catch (PersistenciaException e) {
			String message = "Erro ao gravar o contato no banco";
			logger.log(Level.SEVERE, "Erro ao gravar o contato no banco ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR,message);			
		}
		catch (NegocioException e) {
			throw e;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Erro nao esperado ao salvar contato ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR);
		}
		
		return contatoBean;
	}
	
	

	@Override
	@Transactional
	public void deletarContato(Long id) throws NegocioException{


		logger.log(Level.INFO, "deletar contatos ");
		try{
			Contato c = contatoDao.getContato(id);
			if(c != null){
				contatoDao.deletarContato(c);
			}else{

				throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR,"Contato nao encontrado");
			}
		}
		catch (PersistenciaException e) {
			String message = "Erro ao gravar o contato no banco";
			logger.log(Level.SEVERE, "Erro ao gravar o contato no banco ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR,message);			
		}
		catch (NegocioException e) {
			throw e;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "Erro nao esperado ao salvar contato ",e);
			throw new NegocioException(ResponsesEnum.INTERNAL_SERVER_ERROR);
		}
		
	}

}
