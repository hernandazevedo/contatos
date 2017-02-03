package br.com.angular.recruitment.api.enums;

/**
 * Codigos e descrição das respostas.
 * @author Hernand Azevedo
 *
 */
public enum ResponsesEnum {

	
	OK(201,"Sms sent"),
	INTERNAL_SERVER_ERROR(500,"Internal Server Error"),
	VALIDATION_EXCEPTION(405,"Validation exception"),
	MOBILE_USER_NOT_FOUND(404,"Mobile User not found");
	
	
	
	private int code;
	private String description;

	private ResponsesEnum(int code,String description){
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}

}
