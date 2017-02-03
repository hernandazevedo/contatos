package br.com.angular.recruitment.api.converters;

import br.com.angular.recruitment.api.entidades.Sms;

/**
 * Lógica de transformação do Bean usado no webservice para a entidade que será gravada no banco de dados.
 * @author Hernand Azevedo
 *
 */
public class SmsConverter {

	/**
	 * Converte o bean em uma entidade
	 * @param sms
	 * @return
	 */
	public static Sms convert(br.com.angular.recruitment.api.bean.Sms sms){
		Sms entidade = new Sms();
//		entidade.setId(sms.getId());
		entidade.setBody(sms.getBody());
		entidade.setFrom(sms.getFrom());
		entidade.setTo(sms.getTo());
		entidade.setValidade(sms.getValidade());
		return entidade;
	}
	

	/**
	 * Converte entidade para bean
	 * @param sms
	 * @return
	 */
	public static br.com.angular.recruitment.api.bean.Sms convert(br.com.angular.recruitment.api.entidades.Sms sms){
		br.com.angular.recruitment.api.bean.Sms  entidade = new br.com.angular.recruitment.api.bean.Sms ();
		entidade.setId(sms.getId());
		entidade.setBody(sms.getBody());
		entidade.setFrom(sms.getFrom());
		entidade.setTo(sms.getTo());
		entidade.setValidade(sms.getValidade());
		return entidade;
	}
}