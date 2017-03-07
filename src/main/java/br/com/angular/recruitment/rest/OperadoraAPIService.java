package br.com.angular.recruitment.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.angular.recruitment.api.bean.OperadoraBean;
import br.com.angular.recruitment.api.enums.ResponsesEnum;
import br.com.angular.recruitment.api.exceptions.NegocioException;
import br.com.angular.service.OperadoraServiceBo;

@Component
@Path("/operadoras")
public class OperadoraAPIService {

	
	private Logger logger = Logger.getLogger(OperadoraAPIService.class.getName());
	
	@Autowired
	private OperadoraServiceBo operadoraServiceBo;
	/**
	 * Metodo que envia sms
	 * @param contato
	 * @return
	 */
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarTodos() {

		try{
		
			List<OperadoraBean> lista = operadoraServiceBo.listarTodos();
			return Response.status(ResponsesEnum.HTTP_OK.getCode()).entity(lista).build();
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
