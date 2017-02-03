package br.com.angular.recruitment.api.bean;

import java.io.Serializable;

/**
 * Bean usado para transportar os dados do sms
 * @author Hernand Azevedo
 *
 */
public class Sms implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String from;
	private String to;
	private String body;
	private String validade; // dd/MM/YYYY
	
	public Sms() {
	}
	
	public Sms(int id, String from, String to, String body, String validade) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.body = body;
		this.validade = validade;
	}
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
	@Override
	public String toString() {
		return "Sms [id=" + id + ", from=" + from + ", to=" + to + ", body=" + body + ", validade=" + validade + "]";
	}
	
}
