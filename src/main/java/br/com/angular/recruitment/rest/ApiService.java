package br.com.angular.recruitment.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.angular.recruitment.api.bean.Sms;
import br.com.angular.recruitment.api.enums.ResponsesEnum;
import br.com.angular.recruitment.api.exceptions.NegocioException;
import br.com.angular.service.SmsServiceBo;

/**
 * Classe responsavel por receber as chamadas rest.
 * @author Hernand Azevedo
 *
 */
@Component
@Path("/sms")
public class ApiService {

	/**
	 * servico responsavel por tratar as regras de negocio do envio de sms e abrir a transacao com o banco de dados.
	 */
	@Autowired
	private SmsServiceBo smsServiceBo;

	private Logger logger = Logger.getLogger(ApiService.class.getName());

	/**
	 * Metodo que envia sms
	 * @param sms
	 * @return
	 */
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response sendSMS(Sms sms) {

		try{
		
			smsServiceBo.enviar(sms);
			return Response.status(ResponsesEnum.OK.getCode()).header("description", ResponsesEnum.OK.getDescription()).build();
		}catch(NegocioException e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			return Response.status(e.getResponse().getCode()).header("description", e.getMessage()).build();			
		}
		catch(Exception e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			return Response.status(ResponsesEnum.INTERNAL_SERVER_ERROR.getCode()).header("description", ResponsesEnum.INTERNAL_SERVER_ERROR.getDescription()).build();
		}

	}
	
	
	/**
	 * Metodo que lista os sms
	 * @param sms
	 * @return
	 */
	@GET
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getSMS() {

		try{
		
			List<Sms> lista = smsServiceBo.listarTodos();

			return Response.status(ResponsesEnum.OK.getCode()).header("description", ResponsesEnum.OK.getDescription()).entity(lista).build();
		}catch(NegocioException e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			return Response.status(e.getResponse().getCode()).header("description", e.getMessage()).build();			
		}
		catch(Exception e){
			logger.log(Level.SEVERE, e.getMessage(), e);
			return Response.status(ResponsesEnum.INTERNAL_SERVER_ERROR.getCode()).header("description", ResponsesEnum.INTERNAL_SERVER_ERROR.getDescription()).build();
		}

	}
}