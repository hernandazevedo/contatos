package br.com.angular.recruitment.api.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade que grava no banco o sms enviado
 * @author Hernand Azevedo
 *
 */
@Entity
@Table(name="sms")
public class Sms implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Sms() {
	}
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sms_id")
	private int id;
	
	@Column(name = "sms_from")
	private String from;
	@Column(name = "sms_to")
	private String to;
	@Column(name = "sms_body")
	private String body;
	@Column(name = "sms_validade")
	private String validade;
	
	@Column(name = "sms_data_envio")
	private Date dataEnvio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
}
