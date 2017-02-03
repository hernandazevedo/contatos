package br.com.angular.recruitment.api.exceptions;

import br.com.angular.recruitment.api.enums.ResponsesEnum;

/**
 * Exception usada na camada de negócio.
 * @author Hernand Azevedo
 *
 */
public class NegocioException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResponsesEnum response;
	
	public NegocioException() {
	
	}

	public NegocioException(ResponsesEnum response,String msg) {
		super(msg);
		this.response = response;
	}
	
	public NegocioException(ResponsesEnum response) {
		super(response.getDescription());
		this.response = response;
	}
	
	public ResponsesEnum getResponse() {
		return response;
	}
}
