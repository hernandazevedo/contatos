package br.com.angular.recruitment.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.angular.recruitment.api.bean.ContatoBean;
import br.com.angular.recruitment.api.enums.ResponsesEnum;
import br.com.angular.recruitment.api.exceptions.NegocioException;
import br.com.angular.service.ContatoServiceBo;

@Component
@Path("/contatos")
public class ContatoAPIService {

	private Logger logger = Logger.getLogger(ContatoAPIService.class.getName());
	
	@Autowired
	private ContatoServiceBo contatoServiceBo;
	
	/**
	 * Metodo que salva contatos
	 * @param contato
	 * @return
	 */
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response salvar(ContatoBean contato) {

		try{
		
			contatoServiceBo.salvar(contato);
			return Response.status(ResponsesEnum.HTTP_CREATED.getCode()).build();
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
	 * Metodo que envia sms
	 * @param contato
	 * @return
	 */
	@GET
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarTodos() {

		try{
		
			List<ContatoBean> lista = contatoServiceBo.listarTodos();
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

	
	/**
	 * Metodo que envia sms
	 * @param contato
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getContato(@PathParam("id") Long id) {

		try{
		
			ContatoBean contato = contatoServiceBo.getContato(id);
			return Response.status(ResponsesEnum.HTTP_OK.getCode()).entity(contato).build();
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
	 * Metodo que envia sms
	 * @param contato
	 * @return
	 */
	@DELETE
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response deletarContato(@PathParam("id") Long id) {

		try{
		
			contatoServiceBo.deletarContato(id);
			return Response.status(ResponsesEnum.HTTP_OK.getCode()).build();
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
