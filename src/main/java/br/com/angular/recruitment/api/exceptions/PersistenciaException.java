package br.com.angular.recruitment.api.exceptions;

/**
 * Exception usada na camada dao.
 * @author Hernand Azevedo
 *
 */
public class PersistenciaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenciaException() {
		
	}

	public PersistenciaException(String msg) {
		super(msg);
	}
}
